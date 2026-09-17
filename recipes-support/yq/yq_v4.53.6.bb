SUMMARY = "yq - prebuilt CLI tool"
DESCRIPTION = "yq installed from the upstream GitHub release binary \
(mikefarah/yq). Prebuilt aarch64 release assets; this tool ships no arm32 assets."
HOMEPAGE = "https://github.com/mikefarah/yq"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://yq-LICENSE;md5=e40a0dcd62f8269b9bff37fe9aa7dcc2"

# Prebuilt aarch64 release assets only.
COMPATIBLE_HOST = "aarch64.*-linux"

SRC_URI = "https://github.com/mikefarah/yq/releases/download/v4.53.6/yq_linux_arm64.tar.gz;name=bin;subdir=bin \
           https://raw.githubusercontent.com/mikefarah/yq/v4.53.6/LICENSE;name=lic;downloadfilename=yq-LICENSE;subdir=lic \
"
SRC_URI[bin.sha256sum] = "d5e7531273d45c5d4b7abb4a1597c47a0fecb5d6b081dfa755064b38ffcc34f4"
SRC_URI[lic.md5sum] = "e40a0dcd62f8269b9bff37fe9aa7dcc2"

S = "${WORKDIR}/lic"

inherit github-release
GH_BINS = "yq_linux_arm64:yq"
