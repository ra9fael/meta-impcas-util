# meta-impcas-util

User-environment and development-tool configuration shared across IMPCAS
PetaLinux projects (Yocto scarthgap / PetaLinux 2024.2):

* `vim` bbappend -- deploys the embedded-development vimrc (system-wide) and
  pulls in `fzf`
* `packagegroup-impcas-cli` -- selects the whole CLI toolkit as a single
  rootfs entry (`CONFIG_packagegroup-impcas-cli=y`); new tool recipes belong
  in its `RDEPENDS` so they ship by default. Individual recipes stay
  selectable in the rootfs menu for minimal images.

The impcas-* family uses the maintainer prefix (it also owns the unique
BBFILE_COLLECTIONS namespace) and the suffix names the theme:
meta-impcas-epics = EPICS, meta-impcas-site = per-machine BOOT-partition
provisioning, meta-impcas-util = user environment tooling.
