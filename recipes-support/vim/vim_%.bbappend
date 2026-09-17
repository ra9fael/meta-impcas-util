# Deploy the embedded-development vimrc as the system-wide vim
# configuration. oe-core's vim loads its config from
# /usr/share/vim/vimrc ($VIM/vimrc -- it does NOT read /etc/vim/vimrc,
# that is a Debian convention), so the bbappend replaces the example
# vimrc the recipe installs; ownership stays with the vim-vimrc package.
# The vimrc expects the fzf binary and vim integration from the fzf
# package in this layer.
#
# Everything is scoped to class-target: the vim recipe also builds a
# native variant (BBCLASSEXTEND), and unscoped changes would alter
# vim-native's task signatures -- breaking the PetaLinux locked-sigs
# sstate reuse for it (see build/conf/locked-sigs.inc).

FILESEXTRAPATHS:prepend:class-target := "${THISDIR}/files:"

SRC_URI:append:class-target = "file://vimrc"

RDEPENDS:${PN}-vimrc += "fzf"

do_install:append:class-target() {
    install -m 0644 ${WORKDIR}/vimrc ${D}${datadir}/vim/vimrc
}
