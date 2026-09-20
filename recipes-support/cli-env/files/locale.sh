# glibc >= 2.35 ships C.UTF-8 built in, without a locale archive; without
# LANG set the shell runs in the bare POSIX locale and tools like btop
# refuse to start ("No UTF-8 locale detected").
export LANG=C.UTF-8
