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

## [0.20.4] - 2026-10-06

### Added
- Add direct filesystem storage bypassing SAF picker
- Add onboarding permissions request for external storage
- Add temp files delete action to download queue
- Add toggle hardware bitmaps for manga covers
- Add global search history
- Add webtoon smooth scroll preference
- Add on App local tracking
- Add legacy storage permission check for saving covers
- Add local source filtering
- Add setting to hide pending extension updates count
- Support dynamic theme for older android
- Add uninstall orphaned button on extension list
- Add Gotham theme
- Add disable doubletap option to paged reader
- Add setting to hide Last Used sources section

### Changed
- Refactor Pinned Only toggle for global search
- Use custom decoder in wide page operations
- Use tiled decoding for big webtoon image
- Set Smart Update feature to off by default
- Revert "Stop tap zones from triggering when scrolling is stopped by tapping"
- Refactor Release build into foss

### Fixed
- Fix thread leak on global search screen
- Fix default category and manga sometimes not having their category restored
- Fix calendar to follow system locale change
- Fix update badge overflow
- Fix tracking date selection for all timezones
- Fix page flashing on auto background
- Fix split wide pages cause IndexOutOfBoundsException crash
- Fix Search keyboard not closing on Enter and reopening on navigation back

### Improved
- Improve download and directory access performance
- Include local source in global search results
- Handle downloads for chapters removed from source
- Feat add parallel chapters download
- Feat resume History from last seen page
- Feat option delete history on time range
- Parallelize per-manga chapter listing
- Feat save one-shot as pdf

### Other
- Moved bookmark from reader top bar to bottom bar
- Skip duplicate chapters in chapter list
- Let SliderPreference collect its own preference
- Limit author and artist name lines to 1 with ellipsis
- Attempt to solve challenge when interactive

### Removed
- Removed smart update logics
- Removed 3rd party tracking stuff while keeping backup compatible
