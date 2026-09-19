SUMMARY = "IMPCAS on-target debugging and diagnostics tool set"
DESCRIPTION = "One rootfs menu entry selecting the debugging/diagnostics \
toolkit (system monitors, profilers, stress/memory tests, hardware bus \
helpers) that is not exposed by the PetaLinux rootfs menu. New debug \
tools belong here so they ship by default."
HOMEPAGE = "https://github.com/ra9fael/meta-impcas-util"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

# libgpiod's main package is Debian-renamed to libgpiod2; allarch packagegroups
# must not RDEPENDS on renamed packages (oe-core QA error), so depend on the
# tools subpackage -- its shlib deps pull the library in.
RDEPENDS:${PN} = " \
    btop \
    devmem2 \
    evtest \
    fio \
    htop \
    iperf3 \
    iotop \
    iproute2-ss \
    libgpiod-tools \
    lshw \
    ltrace \
    memtester \
    picocom \
    psmisc \
    spidev-test \
    stress-ng \
    trace-cmd \
    tree \
    valgrind \
"
