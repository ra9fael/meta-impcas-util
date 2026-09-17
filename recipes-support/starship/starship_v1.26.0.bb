SUMMARY = "starship - prebuilt CLI tool"
DESCRIPTION = "starship installed from the upstream GitHub release binary \
(starship/starship). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/starship/starship"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://starship-LICENSE;md5=a25cce5cb436456c4b21461a3ff95b0d"

# Prebuilt aarch64 release assets only.
COMPATIBLE_HOST = "aarch64.*-linux"

SRC_URI = "https://github.com/starship/starship/releases/download/v1.26.0/starship-aarch64-unknown-linux-musl.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/starship/starship/v1.26.0/LICENSE;name=lic;downloadfilename=starship-LICENSE;subdir=lic \
"
SRC_URI[bin.sha256sum] = "dc30189378d2f2e287384e8a692d3f95ad1df64cf0e8c36aa9201516028aed6b"
SRC_URI[lic.md5sum] = "a25cce5cb436456c4b21461a3ff95b0d"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "starship:starship"
