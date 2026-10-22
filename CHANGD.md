# Changelog

All notable changes to this repository will be documented in this file.

> [!NOTE]
> Keep in mind that the commit SHA may changed each time I do a rebase, so the tagged release may not be accurate.

The format is a modified version of [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this repository don't fucking care for [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

- `Added` - for new features.
- `Changed ` - for changes in existing functionality.
- `Improved` - for enhancement or optimization in existing functionality.
- `Removed` - for currently removed features.
- `Fixed` - for any bug fixes.
- `Other` - for technical stuff.

### Added
- Add 3 hours auto backup schedule
- Add retry on throttled GET requests with backoff
- Add backup retention setting
- Add global search history
- Add setting to hide Last Used sources section
- Add the Keiyoushi extension store by default
- Add parallel chapters download
- Add Gotham theme
- Add dynamic theme support for older android
- Add direct filesystem storage bypassing SAF picker
- Add onboarding permissions request on permissions step

### Changed
- Hide statistics screen from more tab
- Change storage root and download directory handling fallback
- Change trustExtension default to trusted
- Change the update logic to be more accurate
- Change bookmark from reader top bar to bottom bar
- Refactor Pinned Only toggle for global search
- Revert "Show a wavy progress ring while a chapter downloads"
- Change Smart Update feature default to off
- Rebrand fork
- Update workflows

### Improved
- Improve performance by reducing unnecessary media scanning

### Removed
- Remove unused Installation Id feature
- Remove Conscrypt bloat
- Remove support us screen
- Remove updates and downloads notification warning
- Remove firebase dependencies
