package org.cryptomator.jfuse.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.nio.ByteBuffer;
import java.util.Set;

public class FuseOperationsDecoratorTest {

	private final String path = "/path";
	@SuppressWarnings("OctalInteger")
	private final int mode = 0777;
	private final int flags = 0xDEADBEEF;
	private final int datasync = 1;
	private final long count = 100L;
	private final long offset = 1000L;
	private final FuseContext fuseContext = Mockito.mock(FuseContext.class);
	private final FileInfo fi = Mockito.mock(FileInfo.class);
	private final ByteBuffer buf = ByteBuffer.allocate(0);
	private final FuseOperations delegate = Mockito.mock(FuseOperations.class);
	private final FuseOperationsDecorator decorator = () -> delegate;

	@Test
	public void supportedOperations() {
		var original = Mockito.mock(Set.class);
		Mockito.doReturn(original).when(delegate).supportedOperations();

		var result = decorator.supportedOperations();

		Assertions.assertEquals(original, result);
	}

	@Test
	public void errno() {
		var original = Mockito.mock(Errno.class);
		Mockito.doReturn(original).when(delegate).errno();

		var result = decorator.errno();

		Assertions.assertEquals(original, result);
	}

	@Test
	public void getattr() {
		var stat = Mockito.mock(Stat.class);
		Mockito.doReturn(42).when(delegate).getattr(path, stat, fi, fuseContext);

		var result = decorator.getattr(path, stat, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void readlink() {
		var len = 23L;
		Mockito.doReturn(42).when(delegate).readlink(path, buf, len, fuseContext);

		var result = decorator.readlink(path, buf, len, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void mknod() {
		var rdev = 23;
		Mockito.doReturn(42).when(delegate).mknod(path, (short) mode, rdev, fuseContext);

		var result = decorator.mknod(path, (short) mode, rdev, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void mkdir() {
		Mockito.doReturn(42).when(delegate).mkdir(path, mode, fuseContext);

		var result = decorator.mkdir(path, mode, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void unlink() {
		Mockito.doReturn(42).when(delegate).unlink(path, fuseContext);

		var result = decorator.unlink(path, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void rmdir() {
		Mockito.doReturn(42).when(delegate).rmdir(path, fuseContext);

		var result = decorator.rmdir(path, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void symlink() {
		var linkname = "/path";
		var target = "/destination";
		Mockito.doReturn(42).when(delegate).symlink(linkname, target, fuseContext);

		var result = decorator.symlink(linkname, target, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void rename() {
		var oldpath = "/path";
		var newpath = "/destination";
		Mockito.doReturn(42).when(delegate).rename(oldpath, newpath, flags, fuseContext);

		var result = decorator.rename(oldpath, newpath, flags, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void link() {
		var linkname = "/path";
		var target = "/destination";
		Mockito.doReturn(42).when(delegate).link(linkname, target, fuseContext);

		var result = decorator.link(linkname, target, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void chmod() {
		Mockito.doReturn(42).when(delegate).chmod(path, mode, fi, fuseContext);

		var result = decorator.chmod(path, mode, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void chown() {
		var uid = 100;
		var gid = 1000;
		Mockito.doReturn(42).when(delegate).chown(path, uid, gid, fi, fuseContext);

		var result = decorator.chown(path, uid, gid, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void truncate() {
		var size = 1024L;
		Mockito.doReturn(42).when(delegate).truncate(path, size, fi, fuseContext);

		var result = decorator.truncate(path, size, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void open() {
		Mockito.doReturn(42).when(delegate).open(path, fi, fuseContext);

		var result = decorator.open(path, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void read() {
		Mockito.doReturn(42).when(delegate).read(path, buf, count, offset, fi, fuseContext);

		var result = decorator.read(path, buf, count, offset, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void write() {
		Mockito.doReturn(42).when(delegate).write(path, buf, count, offset, fi, fuseContext);

		var result = decorator.write(path, buf, count, offset, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void statfs() {
		var statvfs = Mockito.mock(Statvfs.class);
		Mockito.doReturn(42).when(delegate).statfs(path, statvfs, fuseContext);

		var result = decorator.statfs(path, statvfs, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void flush() {
		Mockito.doReturn(42).when(delegate).flush(path, fi, fuseContext);

		var result = decorator.flush(path, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void fsync() {
		Mockito.doReturn(42).when(delegate).fsync(path, datasync, fi, fuseContext);

		var result = decorator.fsync(path, datasync, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void release() {
		Mockito.doReturn(42).when(delegate).release(path, fi, fuseContext);

		var result = decorator.release(path, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void opendir() {
		Mockito.doReturn(42).when(delegate).opendir(path, fi, fuseContext);

		var result = decorator.opendir(path, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void readdir() {
		var dirFiller = Mockito.mock(DirFiller.class);
		var offset = 1024L;
		Mockito.doReturn(42).when(delegate).readdir(path, dirFiller, offset, fi, flags, fuseContext);

		var result = decorator.readdir(path, dirFiller, offset, fi, flags, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void fsyncdir() {
		Mockito.doReturn(42).when(delegate).fsyncdir(path, datasync, fi, fuseContext);

		var result = decorator.fsyncdir(path, datasync, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void releasedir() {
		Mockito.doReturn(42).when(delegate).releasedir(path, fi, fuseContext);

		var result = decorator.releasedir(path, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void init() {
		var conn = Mockito.mock(FuseConnInfo.class);
		var cfg = Mockito.mock(FuseConfig.class);

		decorator.init(conn, cfg);

		Mockito.verify(delegate).init(conn, cfg);
	}

	@Test
	public void destroy() {
		decorator.destroy();

		Mockito.verify(delegate).destroy();
	}

	@Test
	public void access() {
		var mask = mode;
		Mockito.doReturn(42).when(delegate).access(path, mask, fuseContext);

		var result = decorator.access(path, mask, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void create() {
		Mockito.doReturn(42).when(delegate).create(path, mode, fi, fuseContext);

		var result = decorator.create(path, mode, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}

	@Test
	public void utimens() {
		var atime = Mockito.mock(TimeSpec.class);
		var mtime = Mockito.mock(TimeSpec.class);
		Mockito.doReturn(42).when(delegate).utimens(path, atime, mtime, fi, fuseContext);

		var result = decorator.utimens(path, atime, mtime, fi, fuseContext);

		Assertions.assertEquals(42, result);
	}
}