package org.cryptomator.jfuse.api;

public record FuseContext(Fuse fuse, int uid, int gid, int pid, int umask) {
}
