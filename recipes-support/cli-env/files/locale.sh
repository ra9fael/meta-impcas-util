# PetaLinux clears IMAGE_LINGUAS, so the image ships no locale data at all
# and the bare POSIX locale breaks tools like btop ("No UTF-8 locale
# detected"). LANG=C.UTF-8 together with the c-utf8-locale package (the
# C.utf8 binary locale this image installs) makes setlocale() resolve.
export LANG=C.UTF-8
