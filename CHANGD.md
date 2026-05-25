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
- Add local epub import ui
- Add onboarding permissions request for external storage
- Add global search history
- Add webtoon smooth scroll setting
- Add bold text toggle for better readability
- Add legacy storage permission check for saving covers
- Add Github theme
- Add parallel chapters download
- Add option to delete history on time range
- Add dynamic theme support for older android
- Add parallelize per-manga chapter listing
- Add legacy storage support, bypassing SAF picker
- Add save one-shot as pdf
- Add Gotham theme
- Add read history when migrating entry with chapters
- Add disable doubletap option to paged reader
- Add setting to hide Last Used sources section

### Changed
- Refactor Pinned Only toggle for global search
- Use custom decoder in wide page operations
- Revert Add high quality WebGPU renderer
- Revert Drop legacy decoder
- Change sorting order of downloaded chapters
- Change attempt to solve Cloudflare challenge when interactive
- Change covers ui to rounded and tweak appbar titles
- Change author and artist name lines limited to 1 with ellipsis
- Make completed download accessible for chapters removed from source
- Change Smart Update feature to off by default
- Revert "Stop tap zones from triggering when scrolling is stopped by tapping"
- Refactor Release build into foss

### Fixed
- Fix blank image on oversized webtoon image
- Fix calendar to follow system locale change
- Fix update badge overflow
- Fix tracking date selection for all timezones
- Fix page flashing on auto background
- Fix split wide pages cause IndexOutOfBoundsException crash
- Fix Search keyboard not closing on Enter and reopening on navigation back

### Improved
- Improve local epub comic reader
- Improve download and directory access performance
- Improve performance by reducing unnecessary media scanning

### Removed
- Remove 3rd party trackers integrations
