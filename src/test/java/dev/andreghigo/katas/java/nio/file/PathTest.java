package dev.andreghigo.katas.java.nio.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * Unit tests for {@link Path} from the NIO API
 * 
 * <ul>
 * <li>file separator</li>
 * <li>path separator</li>
 * <li>normalize</li>
 * <li>resolve</li>
 * <li>resolveSibling</li>
 * <li>relativize</li>
 * </ul>
 * 
 * @see Path
 * 
 * @author andreghigo
 */
public class PathTest {

	// ----------- normalize ------------------

	@Test
	public void normalize_withEmptyPath() {
		Path path = Paths.get("");

		Path normalized = path.normalize();

		assertEquals(Paths.get(""), normalized);
	}

	@Test
	public void normalize_withRelativePath() {
		Path path = Paths.get("A/B/../.");

		Path normalized = path.normalize();

		assertEquals(Paths.get("A"), normalized);
	}

	@Test
	public void normalize_withRelativePathWithoutRedundantElements() {
		Path path = Paths.get("A/B");

		Path normalized = path.normalize();

		assertEquals(path, normalized);
	}

	@Test
	public void normalize_withAbsolutePath() {
		Path path = Paths.get("F:/A/B/../.");

		Path normalized = path.normalize();

		assertEquals(Paths.get("F:/A"), normalized);
	}

	@Test
	public void normalize_withAbsolutePathWithoutRedundantElements() {
		Path path = Paths.get("F:/A/B");

		Path normalized = path.normalize();

		assertEquals(path, normalized);
	}

	@Test
	public void normalize_withAbsolutePathWhenWithRootComponentAllElementsAreRedundant() {
		Path path = Paths.get("F:/./../../../.");

		Path normalized = path.normalize();

		assertEquals(Paths.get("F:/"), normalized);
	}

	/**
	 * If you are at the root directory, and give the command cd .., then nothing
	 * happens, you stay at the root only.
	 */
	@Test
	public void normalize_whenGettingParentAlreadyInRoot() {
		Path path = Paths.get("F:\\..\\..\\..\\..\\..\\..\\");

		Path normalized = path.normalize();

		assertEquals(Paths.get("F:\\"), normalized);
	}

	// ----------- resolve ------------------

	@Test
	public void resolve_whenOtherIsEmpty() {
		Path path1 = Paths.get("F:\\A\\B");
		Path path2 = Paths.get("");

		Path resolved = path1.resolve(path2);
		assertEquals(path1, resolved);

		Path resolved2 = path2.resolve(path1);
		assertEquals(path1, resolved2);
	}

	@Test
	public void resolve_whenThisIsEmptyAndOtherIsNot() {
		Path path1 = Paths.get("");
		Path path2 = Paths.get("F:\\A");

		Path resolved = path1.resolve(path2);
		assertEquals(path2, resolved);

		Path resolved2 = path2.resolve(path1);
		assertEquals(path2, resolved2);
	}

	@Test
	public void resolve_whenOtherIsAbsolute() {
		Path path1 = Paths.get("C");
		Path path2 = Paths.get("F:\\A\\B");

		Path resolved = path1.resolve(path2);
		assertEquals(path2, resolved);

		Path resolved2 = path2.resolve(path1);
		assertEquals(Paths.get("F:\\A\\B\\C"), resolved2);
	}

	@Test
	public void resolve_whenBothAreRelative() {
		Path path1 = Paths.get("C");
		Path path2 = Paths.get("A\\B");

		Path resolved = path1.resolve(path2);
		assertEquals(Paths.get("C\\A\\B"), resolved);

		Path resolved2 = path2.resolve(path1);
		assertEquals(Paths.get("A\\B\\C"), resolved2);
	}

	@Test
	public void resolve_whenBothAreAbsoluteWithDifferentRoot() {
		Path path1 = Paths.get("F:\\C");
		Path path2 = Paths.get("D:\\A\\B");

		Path resolved = path1.resolve(path2);
		assertEquals(Paths.get("D:\\A\\B"), resolved);

		Path resolved2 = path2.resolve(path1);
		assertEquals(Paths.get("F:\\C"), resolved2);
	}

	@Test
	public void resolve_whenBothAreAbsoluteWithSameRoot() {
		Path path1 = Paths.get("F:\\C");
		Path path2 = Paths.get("F:\\A\\B");

		Path resolved = path1.resolve(path2);
		assertEquals(Paths.get("F:\\A\\B"), resolved);

		Path resolved2 = path2.resolve(path1);
		assertEquals(Paths.get("F:\\C"), resolved2);
	}

	@Test
	public void resolve_whenThisIsAbsoluteAndOtherRelative() {
		Path path1 = Paths.get("F:\\C");
		Path path2 = Paths.get("A\\B");

		Path resolved = path1.resolve(path2);
		assertEquals(Paths.get("F:\\C\\A\\B"), resolved);

		Path resolved2 = path2.resolve(path1);
		assertEquals(Paths.get("F:\\C"), resolved2);
	}

	// ----------- resolveSibling ------------------

	@Test
	public void resolveSibling() {
		Path path1 = Paths.get("F:\\C\\D\\E");
		Path path2 = Paths.get("A\\B");

		Path resolved = path1.resolveSibling(path2);
		assertEquals(Paths.get("F:\\C\\D\\A\\B"), resolved);
	}

	// ----------- relativize ------------------

	/**
	 * When paths has different roots, it throws IllegalStateException
	 */
	@Test
	public void relativize_whenTwoPathsHasDifferentRoots() {
		Path path1 = Paths.get("F:\\A\\B\\C");
		Path path2 = Paths.get("C:\\A\\B\\C");

		try {
			path1.relativize(path2);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("'other' has different root", e.getMessage());
		}

		try {
			path2.relativize(path1);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("'other' has different root", e.getMessage());
		}
	}

	/**
	 * Both paths should be of the same type (absolute or relative) if one is
	 * absolute and another relative, then it throws IllegalArgumentException
	 */
	@Test
	public void relativize_whenOnePathIsAbsoluteAndOtherIsRelative() {
		Path path1 = Paths.get("F:\\A\\B\\C");
		Path path2 = Paths.get("B\\C");

		try {
			path1.relativize(path2);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("'other' is different type of Path", e.getMessage());
		}

		try {
			path2.relativize(path1);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			assertEquals("'other' is different type of Path", e.getMessage());
		}
	}

	/**
	 * When both paths are equal, it returns empty path
	 */
	@Test
	public void relativize_whenTwoPathsAreEqual() {
		Path path1 = Paths.get("F:\\A\\B\\C");
		Path path2 = Paths.get("F:\\A\\B\\C");

		assertEquals(Paths.get(""), path1.relativize(path2));
		assertEquals(Paths.get(""), path2.relativize(path1));
		assertEquals(path1.relativize(path2), path2.relativize(path1));
	}

	@Test
	public void relativize_whenTwoPathsAreDifferentWithSameRootAndBothAbsolute() {
		Path path1 = Paths.get("F:\\A\\B\\C");
		Path path2 = Paths.get("F:\\A");

		// How to get from F:\A\B\C to F:\A ? go to parent directory twice -> ..\..
		// because it is relative to F:\A\B\C
		assertEquals(Paths.get("..\\.."), path1.relativize(path2));

		// How to get from F:\A to B\C ? just B\C because it is relative to F:\A
		assertEquals(Paths.get("B\\C"), path2.relativize(path1));
	}

	@Test
	public void relativize_whenTwoPathsAreDifferentAndBothRelative() {
		Path path1 = Paths.get("A\\B\\C");
		Path path2 = Paths.get("A");

		// How to get from A\B\C to A ? go to parent directory twice -> ..\.. because it
		// is relative to A\B\C
		assertEquals(Paths.get("..\\.."), path1.relativize(path2));

		// How to get from A to A\B\C ? just B\C because it is relative to A
		assertEquals(Paths.get("B\\C"), path2.relativize(path1));
	}
}
