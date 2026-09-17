SUMMARY = "zoxide - prebuilt CLI tool"
DESCRIPTION = "zoxide installed from the upstream GitHub release binary \
(ajeetdsouza/zoxide). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/ajeetdsouza/zoxide"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://zoxide-LICENSE;md5=3db2f084b045f74bdb05b1189934c391"

# Prebuilt aarch64 release assets only.
COMPATIBLE_HOST = "aarch64.*-linux"

SRC_URI = "https://github.com/ajeetdsouza/zoxide/releases/download/v0.10.0/zoxide-0.10.0-aarch64-unknown-linux-musl.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/ajeetdsouza/zoxide/v0.10.0/LICENSE;name=lic;downloadfilename=zoxide-LICENSE;subdir=lic \
"
SRC_URI[bin.sha256sum] = "f1f16c5d6298d63dee467eedea1cdcd8490e43e493bea43acd416dc9033ef641"
SRC_URI[lic.md5sum] = "3db2f084b045f74bdb05b1189934c391"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "zoxide:zoxide"
