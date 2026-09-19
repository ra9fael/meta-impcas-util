SUMMARY = "IMPCAS on-target development tool set"
DESCRIPTION = "One rootfs menu entry selecting the on-target source/build \
tooling (compiler toolchains come from packagegroup-core-buildessential): \
parser generators, build systems, patch handling and python packaging. \
New development tools belong here so they ship by default."
HOMEPAGE = "https://github.com/ra9fael/meta-impcas-util"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

RDEPENDS:${PN} = " \
    bison \
    cmake \
    diffstat \
    flex \
    meson \
    ninja \
    patch \
    python3-numpy \
    python3-pip \
    python3-pyserial \
    quilt \
    swig \
"
