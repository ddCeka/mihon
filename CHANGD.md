# Changd

All notable changes to this repository will be documented in this file.

> [!NOTE]
> Keep in mind that the commit SHA may changed each time I do a rebase, so the linked commit may not be accurate.

The format is a modified version of [Keep a Changelog](https://keepachangelog.com/en/1.1.0/), and this repository don't fucking care to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).
- `Added` - for new features.
- `Changed ` - for changes in existing functionality.
- `Improved` - for enhancement or optimization in existing functionality.
- `Removed` - for currently removed features.
- `Fixed` - for any bug fixes.
- `Other` - for technical stuff.

### Added
- Add a toggle to turn on or off Last Used extensions from sources tab menu
- Add option to disable doubletap action to paged reader
- Add Gotham colorscheme
- Add uninstall orphaned button on extension list
- Add option to save one-shot type manga as pdf
- Add legacy storage support by directly access to path folders, bypassing SAF picker
- Add option delete history on time range
- Add toggle hardware bitmaps for manga covers
- Add parallel chapters download
- Add Github colorscheme
- Add setting to hide pending extension updates count
- Add local source filtering
- Add legacy storage permission check for saving covers
- Add bold text toggle for better readability
- Add webtoon smooth scroll preference
- Add global search history
- Add legacy storage permission on onboarding screen

### Changed
- Rebranding to differentiate with upstream
- Refactor release build into foss
- Increase the parallel download page limit to 30, download source limit to 20, parallel download to 2
- Disable the annoying download notification warning when updating library
- Keep the legacy image decoder for this repository
- Revert Fix reader tap zones triggering after scrolling is stopped by tapping, because it doesn't need a fix
- Make Smart Update feature to off by default
- Use custom decoder in wide page operations
- Hide redundant categories screen in more screen
- Hide statistics screen from settings
- Handle downloads for chapters removed from source
- Limit author and artist name lines to 1 with ellipsis
- Changed downloaded chapters update sorting
- Refactor pinned only toggle for global search

### Improved
- Make "Support Us" no more prominent in this repository
- Include read history when migrating entry with chapters
- Parallelize per-manga chapter listing
- Support dynamic theme for older android
- Include local source in global search results
- Ui from rectangle to rounded covers and tweak appbar titles
- Make Cloudflare Interceptor attempt to solve challenge when interactive

### Removed
- Removed uneccessary Telemetry
- Removed discord related codes and cleanup unused stuff
- Removed Installation Id "Feature Flags"
- Removed user timezone tracking in debug logs
- Removed uneccessary clutter in more screen
- Removed annoying updater flags, let the user choose when to update and not get spoon-fed just because it have a "New Update Screen"
- Removed download 1 chapter from drop down menu since it's redundant
- Removed x86 abis build
- Removed the not needed 3rd party tracking fluff. This commit while destructive is still compatible with backup restore from Mihon

### Fixed
- Fixed Search keyboard not closing on Enter and reopening on navigation back
- Fixed janky custom animation splash screen exit for android 12 and below
- Fixed IndexOutOfBoundsException crash when using split wide pages
- Fixed blank image on oversized webtoon pages by using tiled decoding
- Fixed page flashing on auto background
- Fixed tracking date selection for all timezones
- Fixed update badge overflow when having extensions in the 3 digit
- Fixed calendar to follow system locale change
