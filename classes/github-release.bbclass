# Install prebuilt GitHub release binaries into ${bindir}.
#
# Recipes set SRC_URI to fetch their release asset (with subdir=bin) and a
# raw license file, then declare GH_BINS = "srcname:destname ...". This
# class locates each named binary in the fetched assets and installs it
# under its destination name. The release binaries ship already stripped
# (INSANE_SKIP below) and there is nothing to compile.
#
# These recipes are aarch64-only: several upstreams publish no arm32
# release assets, and the fleet is aarch64.

GH_BINS ?= ""

COMPATIBLE_HOST = "aarch64.*-linux"

INSANE_SKIP:${PN} += "already-stripped"

do_compile() {
    :
}

do_install() {
    install -d ${D}${bindir}
    for pair in ${GH_BINS}; do
        src="${pair%%:*}"
        dst="${pair##*:}"
        found=$(find ${WORKDIR} -maxdepth 3 -type f -name "$src" \
            -not -path "*/recipe-sysroot*" -not -path "*/image/*" \
            -not -path "*/temp/*" -not -path "*/deploy*/*" | head -n1)
        if [ -z "$found" ]; then
            bbfatal "github-release: binary '$src' not found in the fetched assets"
        fi
        install -m 0755 "$found" ${D}${bindir}/$dst
    done
}
