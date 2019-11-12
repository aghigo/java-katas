package dev.andreghigo.katas.java.nio;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

/**
 * Unit tests for {@link Path} from NIO API
 * 
 * @see Path
 * 
 * @author andreghigo
 */
public class PathTest {
	
	// ----------- Path.relativize(Path) operation ------------------
	
	@Test
	public void relativize_whenTwoPathsAreEqual() {
		Path path1 = Paths.get("F:\\A\\B\\C");
        Path path2 = Paths.get("F:\\A\\B\\C");
        
        // When both paths are equal, it returns empty path
        assertEquals(Paths.get(""), path1.relativize(path2));
        assertEquals(Paths.get(""), path2.relativize(path1));
        assertEquals(path1.relativize(path2), path2.relativize(path1));
	}
	
	@Test
	public void relativize_whenTwoPathsAreDifferentButWithSameRoot() {
		Path path1 = Paths.get("F:\\A\\B\\C");
        Path path2 = Paths.get("F:\\A");
        
        // How to get from F:\A\B\C to F:\A ? go to parent directory twice -> ..\.. because it is relative to F:\A\B\C
        assertEquals(Paths.get("..\\.."), path1.relativize(path2));
        
        // How to get from F:\A to B\C ? just B\C because it is relative to F:\A
        assertEquals(Paths.get("B\\C"), path2.relativize(path1));
	}
}
