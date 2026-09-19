SUMMARY = "IMPCAS common CLI tool set"
DESCRIPTION = "One rootfs menu entry selecting the shared CLI toolkit \
shipped in this layer (finders, editors, shell enhancement, json/log \
tooling) plus the cli-env shell integration. New tool recipes should be \
added here so they ship by default."
HOMEPAGE = "https://github.com/ra9fael/meta-impcas-util"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

RDEPENDS:${PN} = " \
    bat \
    boo \
    cli-env \
    fd \
    fzf \
    hl \
    lazygit \
    lnav \
    ripgrep \
    starship \
    television \
    uv \
    yazi \
    yq \
    zellij \
    zoxide \
"
