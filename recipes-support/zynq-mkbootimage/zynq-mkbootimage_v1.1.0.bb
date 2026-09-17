SUMMARY = "zynq-mkbootimage - prebuilt CLI tool"
DESCRIPTION = "zynq-mkbootimage installed from the upstream GitHub release binary \
(konosubakonoakua/zynq-mkbootimage). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/konosubakonoakua/zynq-mkbootimage"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://zynq-mkbootimage-LICENSE;md5=0c9c77a4b70683658eb47e5486e20148"

# Prebuilt aarch64 release assets only.
COMPATIBLE_HOST = "aarch64.*-linux"

SRC_URI = "https://github.com/konosubakonoakua/zynq-mkbootimage/releases/download/v1.1.0/zynq-mkbootimage-aarch64-unknown-linux-gnu.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/konosubakonoakua/zynq-mkbootimage/v1.1.0/LICENSE;name=lic;downloadfilename=zynq-mkbootimage-LICENSE;subdir=lic \
"
SRC_URI[bin.sha256sum] = "cae2ae9ad44c9e7fca847a92f6d01372d164366a1952a339f58ef11c6cc8185f"
SRC_URI[lic.md5sum] = "0c9c77a4b70683658eb47e5486e20148"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "exbootimage:exbootimage fpgautil:fpgautil mkbootimage:mkbootimage"

# mkbootimage links against libelf.
RDEPENDS:${PN} += "libelf"
