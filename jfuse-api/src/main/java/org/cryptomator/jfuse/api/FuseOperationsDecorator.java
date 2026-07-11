package org.cryptomator.jfuse.api;

import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;
import java.util.Set;

/**
 * Convenience interface to make decorating {@link FuseOperations} easier.
 */
public interface FuseOperationsDecorator extends FuseOperations {

	/**
	 * Get the to-be-decorated FuseOperations object.
	 *
	 * @return the undecorated operations
	 */
	FuseOperations delegate();

	@Override
	default Set<Operation> supportedOperations() {
		return delegate().supportedOperations();
	}

	@Override
	default Errno errno() {
		return delegate().errno();
	}

	@Override
	default int getattr(String path, Stat stat, @Nullable FileInfo fi, FuseContext fuse_context) {
		return delegate().getattr(path, stat, fi, fuse_context);
	}

	@Override
	default int getxattr(String path, String name, ByteBuffer value, FuseContext fuse_context) {
		return delegate().getxattr(path, name, value, fuse_context);
	}

	@Override
	default int setxattr(String path, String name, ByteBuffer value, int flags, FuseContext fuse_context) {
		return delegate().setxattr(path, name, value, flags, fuse_context);
	}

	@Override
	default int listxattr(String path, ByteBuffer list, FuseContext fuse_context) {
		return delegate().listxattr(path, list, fuse_context);
	}

	@Override
	default int removexattr(String path, String name, FuseContext fuse_context) {
		return delegate().removexattr(path, name, fuse_context);
	}

	@Override
	default int readlink(String path, ByteBuffer buf, long len, FuseContext fuse_context) {
		return delegate().readlink(path, buf, len, fuse_context);
	}

	@Override
	default int mknod(String path, short mode, int rdev, FuseContext fuse_context) {
		return delegate().mknod(path, mode, rdev, fuse_context);
	}

	@Override
	default int mkdir(String path, int mode, FuseContext fuse_context) {
		return delegate().mkdir(path, mode, fuse_context);
	}

	@Override
	default int unlink(String path, FuseContext fuse_context) {
		return delegate().unlink(path, fuse_context);
	}

	@Override
	default int rmdir(String path, FuseContext fuse_context) {
		return delegate().rmdir(path, fuse_context);
	}

	@Override
	default int symlink(String linkname, String target, FuseContext fuse_context) {
		return delegate().symlink(linkname, target, fuse_context);
	}

	@Override
	default int rename(String oldpath, String newpath, int flags, FuseContext fuse_context) {
		return delegate().rename(oldpath, newpath, flags, fuse_context);
	}

	@Override
	default int link(String linkname, String target, FuseContext fuse_context) {
		return delegate().link(linkname, target, fuse_context);
	}

	@Override
	default int chmod(String path, int mode, @Nullable FileInfo fi, FuseContext fuse_context) {
		return delegate().chmod(path, mode, fi, fuse_context);
	}

	@Override
	default int chown(String path, int uid, int gid, @Nullable FileInfo fi, FuseContext fuse_context) {
		return delegate().chown(path, uid, gid, fi, fuse_context);
	}

	@Override
	default int truncate(String path, long size, @Nullable FileInfo fi, FuseContext fuse_context) {
		return delegate().truncate(path, size, fi, fuse_context);
	}

	@Override
	default int open(String path, FileInfo fi, FuseContext fuse_context) {
		return delegate().open(path, fi, fuse_context);
	}

	@Override
	default int read(String path, ByteBuffer buf, long count, long offset, FileInfo fi, FuseContext fuse_context) {
		return delegate().read(path, buf, count, offset, fi, fuse_context);
	}

	@Override
	default int write(String path, ByteBuffer buf, long count, long offset, FileInfo fi, FuseContext fuse_context) {
		return delegate().write(path, buf, count, offset, fi, fuse_context);
	}

	@Override
	default int statfs(String path, Statvfs statvfs, FuseContext fuse_context) {
		return delegate().statfs(path, statvfs, fuse_context);
	}

	@Override
	default int flush(String path, FileInfo fi, FuseContext fuse_context) {
		return delegate().flush(path, fi, fuse_context);
	}

	@Override
	default int fsync(String path, int datasync, FileInfo fi, FuseContext fuse_context) {
		return delegate().fsync(path, datasync, fi, fuse_context);
	}

	@Override
	default int release(String path, FileInfo fi, FuseContext fuse_context) {
		return delegate().release(path, fi, fuse_context);
	}

	@Override
	default int opendir(String path, FileInfo fi, FuseContext fuse_context) {
		return delegate().opendir(path, fi, fuse_context);
	}

	@Override
	default int readdir(String path, DirFiller filler, long offset, FileInfo fi, int flags, FuseContext fuse_context) {
		return delegate().readdir(path, filler, offset, fi, flags, fuse_context);
	}

	@Override
	default int fsyncdir(@Nullable String path, int datasync, FileInfo fi, FuseContext fuse_context) {
		return delegate().fsyncdir(path, datasync, fi, fuse_context);
	}

	@Override
	default int releasedir(@Nullable String path, FileInfo fi, FuseContext fuse_context) {
		return delegate().releasedir(path, fi, fuse_context);
	}

	@Override
	default void init(FuseConnInfo conn, @Nullable FuseConfig cfg) {
		delegate().init(conn, cfg);
	}

	@Override
	default void destroy() {
		delegate().destroy();
	}

	@Override
	default int access(String path, int mask, FuseContext fuse_context) {
		return delegate().access(path, mask, fuse_context);
	}

	@Override
	default int create(String path, int mode, FileInfo fi, FuseContext fuse_context) {
		return delegate().create(path, mode, fi, fuse_context);
	}

	@Override
	default int utimens(String path, TimeSpec atime, TimeSpec mtime, @Nullable FileInfo fi, FuseContext fuse_context) {
		return delegate().utimens(path, atime, mtime, fi, fuse_context);
	}

}
