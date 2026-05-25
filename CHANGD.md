# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project don't fucking care for [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.20.4] - 2026-09-06

### Added
- Add onboarding permissions request for external storage
- Add toggle hardware bitmaps for manga covers
- Add global search history
- Add webtoon smooth scroll preference
- Add on App local tracking
- Add legacy storage permission check for saving covers
- Add local source filtering
- Add setting to hide pending extension updates count
- Feat add parallel chapters download
- Feat resume History from last seen page
- Feat option delete history on time range
- Support dynamic theme for older android
- Add legacy storage support, bypassing SAF picker
- Feat save one-shot as pdf
- Add uninstall orphaned button on extension list
- Add Gotham theme
- Add disable doubletap option to paged reader
- Add setting to hide Last Used sources section

### Changed
- Retag v0.20.4
- Refactor library category tab to pop overlay screen
- Refactor Pinned Only toggle for global search
- Improve download and directory access performance
- Limit author and artist name lines to 1 with ellipsis
- Change downloaded chapters order sorting
- Attempt to solve challenge when interactive
- Group chapters by entry in updates tab
- Include local source in global search results
- Handle downloads for chapters removed from source
- Parallelize per-manga chapter listing
- Use custom decoder in wide page operations
- Include read history when migrating entry with chapters
- Use tiled decoding for big webtoon image
- Set Smart Update feature to off by default
- Revert "Stop tap zones from triggering when scrolling is stopped by tapping"
- Refactor Release build into foss
- Suppress R8 warnings for missing androidx.window extension classes
- Translations update from Hosted Weblate
- Replace CategoryUpdate with dedicated update queries
- Update broken repo images
- Respect verbose logging preference in crash log dumps

### Fixed
- Fix calendar to follow system locale change
- Fix update badge overflow
- Fix tracking date selection for all timezones
- Fix page flashing on auto background
- Fix split wide pages cause IndexOutOfBoundsException crash
- Fix Search keyboard not closing on Enter and reopening on navigation back
- Fix relative date display

### Removed
- Removed smart update logics
- Removed 3rd party tracking stuff while keeping backup compatible

## [0.20.3] - 2026-08-04

### Added
- Add category filters to Upcoming calendar
- Add category filters for Updates tab

### Changed
- Release v0.20.3
- Update gradle/actions action to v6.3.0
- Improve WebView spoofing
- Ensure R8 keeps methods called externally by Shizuku
- Replace java.time APIs with kotlin(x).(date)time

### Fixed
- Fix MAL error when list entries have partial dates
- Fix reader loading indefinitely in some scenarios

## [0.20.2] - 2026-08-01

### Added
- Add Tokyo Night theme
- Add MangaBaka to README list of trackers
- Add Vietnamese translation for fastlane metadata
- Add fastlane metadata

### Changed
- Release v0.20.2
- Update dependency com.google.firebase:firebase-bom to v34.17.0
- Translations update from Hosted Weblate
- Update actions/setup-java action to v5.7.0
- Regenerate baseline profiles
- Improve app update prompt flow experience
- Update dependency org.jsoup:jsoup to v1.23.1
- Update dependency androidx.constraintlayout:constraintlayout to v2.2.2
- Update dependency androidx.compose:compose-bom-alpha to v2026.07.01
- Update dependency androidx.baselineprofile to v1.5.0-beta01
- Check for app and extension update on every cold start
- Update dependency com.squareup.okio:okio to v3.18.1
- Update spotless to v8.9.0
- Collect data on device preferred abi
- Convert :source-api and :source-local to android library module
- Optimize imports across all modules
- Update android.gradle to v9.3.1
- Update dependency com.squareup.okio:okio to v3.18.0
- Rework library search to use an AST-based approach
- Update dependency io.kotest:kotest-assertions-core to v6.2.3
- Always use Private installer to update Private extensions
- Update dependency androidx.compose:compose-bom-alpha to v2026.07.00
- Update actions/checkout action to v7.0.1
- Update actions/setup-java action to v5.6.0
- Update aboutLibraries to v15.0.4
- Detect Shizuku with permission check
- Migrate to AndroidX ViewModel from Voyager ScreenModel
- Update android.gradle to v9.3.0
- Update kotlin monorepo to v2.4.10
- Update softprops/action-gh-release action to v3.0.2
- Update dependency org.conscrypt:conscrypt-android to v2.6.1
- Update dependency org.junit.jupiter:junit-jupiter to v6.1.2
- Update dependency com.materialkolor:material-kolor to v5.0.0
- Update dependency com.google.firebase:firebase-bom to v34.16.0
- Revert "Disable resumable image downloads"

### Fixed
- Fix backup restore dropping library entries
- Fix extension installation with shizuku
- Fix incorrect progress when resuming resumable image downloads
- Fix crash caused by inaccessible view model classes during creation
- Fix MangaBaka User-Agent using raw StringResource
- Fixed app bars remaining visible after changing pages by tapping in the paged reader after using the chapter navigator slider

### Removed
- Remove workarounds for patched compose bugs
- Remove non cancellable call when trying to init reader

## [0.20.1] - 2026-07-09

### Added
- Add proguard rule for com.squareup.zstd
- Add vertical chapter navigator for paged reader with height adjustment option
- Add MangaBaka tracker support
- Add Hikka tracker support
- Add proguard rules to keep Serializable writeReplace and readResolve
- Address compose and xmlutil deprecations
- Support resumable image downloads if supported by source

### Changed
- Release v0.20.1
- Disable resumable image downloads
- Translations update from Hosted Weblate
- Regenerate baseline profiles
- Update xmlutil to v1.0.1
- Update aboutLibraries to v15
- Update dependency org.conscrypt:conscrypt-android to v2.6.0
- Update dependency io.kotest:kotest-assertions-core to v6.2.2
- Update actions/setup-java action to v5.5.0
- Don't use GMS to detect if GMS is available
- Show usernames for each tracker in settings
- Set PLAN_TO_READ for manga with no progress
- Revert "Fix crash when putting app in background while on notes screen "
- Invalidate download cache after backup restore
- Use Shikimori's GraphQL API where possible
- Update dependency androidx.test.uiautomator:uiautomator to v2.4.0
- Update dependency androidx.sqlite:sqlite-bundled to v2.7.0
- Update dependency androidx.compose:compose-bom-alpha to v2026.06.01
- Update dependency androidx.baselineprofile to v1.5.0-alpha07
- Update spotless to v8.8.0
- Update xmlutil to v1
- Update dependency org.junit.jupiter:junit-jupiter to v6.1.1
- Update voyager to 2.2.21-1.10.3

### Fixed
- Fix HTTP Error 416 not being handled properly for resumable downloads
- Fix underscore in Hikka media types
- Fix app not reading `tachiyomix.extensionLib` extension metadata 2
- Fix Hikka search failing due to unclosed response & show toast on remote-removed titles
- Fix reader navigator slider steps not updating after changing chapter
- Fix app not reading `tachiyomix.extensionLib` extension metadata
- Fix chapter's `memo` field not being updated for existing chapters
- Fix support for non-system SAF providers
- Fix crash when putting app in background
- Fix crash trying to select text in notes screen
- Fix crash when putting app in background while on notes screen
- Fix downloads not working due to wrong file check
- Fix duplicate images after resuming paused downloads
- Fix Shikimori URL

### Removed
- Remove flag to disable code shrinking

## [0.20.0] - 2026-06-26

### Added
- Add option to open app settings from system settings
- Address gradle 9.6 deprecations
- Address various redundant constructs
- Add auto migration support from legacy extension store index
- Add paddings to vertical chapter navigator
- Add vertical chapter navigator for long strip mode
- Add missing `outlineVariant` color to Nord theme

### Changed
- Release v0.20.0
- Update Gradle to v9.6.1
- Ensure app shortcuts use correct color scheme on preview builds
- Update store decoding to account for new CONTENT_WARNING_UNSPECIFIED
- Update actions/setup-java action to v5.4.0
- Ensure all tachiyomix required dependencies are present
- Query for new tachiyomix metadata from extensions
- Update app shortcuts to use app icon color scheme
- Prevent random `FileNotFoundException` when reading chapters
- Tweak Catppuccin color scheme for clarity
- Translations update from Hosted Weblate
- Batch database operations during backup restore for improved performance
- Update markdown to v0.43.0
- Bump version code
- Refactor baseline profiles generation and regenerate
- Swap store content rating for warning and move to extension level
- Allow extension stores to have separate extension list file
- Simplify extension store decoding and add gzip compression support
- Update markdown to v0.42.0
- Update softprops/action-gh-release action to v3.0.1
- Update GitHub Actions to v7
- Update kotest.assertions to v6.2.1
- Update Gradle to v9.6.0
- Revert "Use app scoped CoroutineScope "
- Update androidx.lifecycle to v2.11.0
- Update androidx.compose.bom to v2026.06.00
- Only try to read signing data in release workflow
- Sign APK with AGP
- Update google.services to v4.5.0
- Update firebase.bom to v34.15.0
- Update actions/setup-java to v5.3.0
- Update GitHub Actions (major)
- Update spotless to v8.7.0
- Update kotest.assertions to v6.2.0
- Ensure chapter order is retained when passed to `source.getMangaUpdate`
- Update `num_repos` string to use store
- Ensure memo is correctly passed around when transforming classes
- Allow app to load TachiyomiX 1.6 extensions
- Adapt model implementation for TachiyomiX 1.6
- Suppress more tachiyomix-related deprecations
- Adapt source implementation for TachiyomiX 1.6
- Adapt network implementation for TachiyomiX 1.6
- Ensure old extension store is removed if index url changes
- Supress UnstableApiUsage in settings.gradle.kts
- Use `. toDrawable` extension function in ImageUtil
- Use duration overload for time related methods
- Use app scoped CoroutineScope
- Update coil to v3.5.0
- Change the term "Obsolete" to "Orphaned" for extensions
- Use our fork of sqldelight-androidx-driver
- Update firebase.bom to v34.14.1
- Update okhttp monorepo to v5.4.0
- Use more sqldelight coroutines extensions
- Extract badge data separately when forming LibraryItem
- Update androidx.core to v1.19.0
- Drop kotlinx-collections-immutable usage
- Update androidx.compose.bom to v2026.05.02
- Update kotlin monorepo to v2.4.0
- Change extension repo to extension store and add support for newer extension index format
- Use RECEIVER_NOT_EXPORTED for ShizukuInstaller broadcast receiver
- Update markdown to v0.41.0
- Update GitHub Actions to v6.0.3
- Update androidx.paging to v3.5.0
- Update dependency io.mockk:mockk to v1.14.11
- Update dependency com.google.firebase:firebase-bom to v34.14.0
- Update spotless to v8.6.0
- Update aboutLibraries to v14.2.1
- Update dependency androidx.compose:compose-bom-alpha to v2026.05.01
- Update dependency org.junit.jupiter:junit-jupiter to v6.1.0
- Update spotless to v8.5.1
- Update Gradle to v9.5.1
- Update dependency com.mohamedrejeb.richeditor:richeditor-compose to v1.0.0-rc14
- Update dependency com.eygraber:sqldelight-androidx-driver to v0.2.0
- Update aboutLibraries to v14.2.0
- Update dependency com.google.firebase:firebase-bom to v34.13.0
- Update dependency androidx.compose:compose-bom-alpha to v2026.05.00
- Update kotlinx-coroutines monorepo to v1.11.0
- Update moko.resources to v0.26.4
- Update android.gradle to v9.2.1
- Update Gradle to v9.5.0
- Update sqldelight-androidx-driver and remove transaction management
- Reapply "Update android.gradle to v9 (major) "
- Update dependency image-decoder to e03b81e18a
- Update dependency androidx.compose:compose-bom-beta to v2026.04.01
- Update dependency sh.calvin.reorderable:reorderable to v3.1.0
- Update kotlin monorepo to v2.3.21
- Update softprops/action-gh-release action to v2.6.2
- Update dependency com.gradleup.tapmoc:tapmoc-gradle-plugin to v0.4.2
- Update dependency org.jsoup:jsoup to v1.22.2

### Fixed
- Fix uploaded apk reference in build workflow
- Fix compatibility with older backups
- Fix chapters and categories not being added to database

### Removed
- Remove BrotliInterceptor from default client
- Remove redundant call to `updateMangaFromRemote` in manga screen
- Remove text limit of manga notes
- Remove redundant compiler argument for annotation default target
- Remove redundant compiler argument for context parameter
- Remove redundant KGP classpath in :app

## [0.19.9] - 2026-04-11

### Changed
- Release v0.19.9
- Revert "Remove usage of deprecated `LocalBroadcastManager` "
- Revert "Update dependency com.google.android.material:material to v1.13.0 "

## [0.19.8] - 2026-04-11

### Added
- Add a one time popup asking for donation from long time users
- Add dedicated "Support Us" screen
- Add `gradle.properties` to `build-logic` synced with root `gradle.properties`
- Add informative error for unapproved MAL titles
- Address Gradle warning about `Task.project`
- Address CancellableContinuation.resume deprecation

### Changed
- Release v0.19.8
- Translations update from Hosted Weblate
- Update dependency com.google.firebase:firebase-bom to v34.12.0
- Update dependency com.google.firebase.crashlytics to v3.0.7
- Update aboutLibraries to v14.0.1
- Slightly tweak paragraph 3 of donation popup
- Translations update from Hosted Weblate
- Update kotlinx.serialization to v1.11.0
- Update dependency com.google.android.material:material to v1.13.0
- Update moko.resources to v0.26.3
- Update aboutLibraries to v14 (major)
- Update dependency androidx.compose:compose-bom-beta to v2026.04.00
- Show AniList publishing type based on country of origin
- Update dependency androidx.annotation:annotation to v1.10.0
- Update moko.resources to v0.26.2
- Make "Support Us" more prominent on More tab
- Update dependency io.kotest:kotest-assertions-core to v6.1.11
- Run tests before compiling APK in CI
- Run SQLDelight database migration verification task in CI
- Update dependency com.gradleup.tapmoc:tapmoc-gradle-plugin to v0.4.1
- Update dependency io.kotest:kotest-assertions-core to v6.1.10
- Don't prompt users to enable Google Play services if disabled or unavailable
- Update dependency androidx.compose:compose-bom-beta to v2026.03.01
- Update r0adkll/sign-android-release digest to a391126
- Update dependency androidx.work:work-runtime to v2.11.2
- Use plural forms for update error notification
- Merge tag 'v0.19.7'
- Revert "Update android.gradle to v9 (major) "
- Update dependency io.kotest:kotest-assertions-core to v6.1.9
- Update dependency io.kotest:kotest-assertions-core to v6.1.8
- Update android.gradle to v9 (major)
- Update Gradle to v9
- Cleanup and rework build logic
- Translations update from Hosted Weblate
- Merge and cleanup version catalogs

### Fixed
- Fix AniList user list item fetch erroring
- Fix app trying to split long strip when not needed

### Removed
- Remove usage of deprecated `LocalBroadcastManager`

## [0.19.7] - 2026-03-23

### Changed
- Release v0.19.7

## [0.19.6] - 2026-03-23

### Changed
- Release v0.19.6
- Potentially fix 'database is locked' crash

### Fixed
- Fix app crash on startup on some Android TV
- Fix occasional crash when mass installing/uninstalling extension using `PackageManager`
- Fix wrong exception being caught after 8c480c6355 migration

## [0.19.5] - 2026-03-20

### Added
- Address bundleOf deprecation
- Add installation id for feature flags

### Changed
- Release v0.19.5
- Revert "Fix thread starvation caused by not yielding or using an inappropriate thread pool "
- Revert "Fix cache invalidation isn't done at startup "
- Update dependency com.google.firebase:firebase-bom to v34.11.0
- Replace preference getter functions with properties
- Make retry in reader redownload image
- Update CHANGELOG.md
- MangaUpdates API content-type heade
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v8.4.0
- Switch to AndroidX bundled sqlite driver
- Update softprops/action-gh-release action to v2.6.1
- Update paging.version to v3.4.2
- Update kotlin monorepo to v2.3.20
- Update sqldelight to v2.3.2
- Update sqldelight to v2.3.1
- Update dependency io.kotest:kotest-assertions-core to v6.1.7
- Update moko to v0.26.1
- Update dependency com.squareup.okio:okio to v3.17.0
- Update softprops/action-gh-release action to v2.5.3
- Update dependency androidx.activity:activity-compose to v1.13.0
- Update dependency androidx.core:core-ktx to v1.18.0
- Update dependency androidx.compose:compose-bom to v2026.03.00
- Bump workflows JDK to 21
- Update dependency androidx.compose:compose-bom to v2026.02.01
- Update dependency com.google.firebase:firebase-bom to v34.10.0
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v8.3.0
- Update dependency com.materialkolor:material-kolor to v5.0.0-alpha07
- Update actions/dependency-review-action action to v4.9.0
- Reapply "Fix cache invalidation isn't done at startup "
- Reapply "Fix thread starvation caused by not yielding or using an inappropriate thread pool "

### Fixed
- Fix extension actions disappearing after installing and uninstalling in same session
- Fix WebView JavaScript dialogs popup after screen is closed
- Fix tracker-induced duplicate key crash in duplicate detection

## [0.19.4] - 2026-02-26

### Added
- Add all pages of adjacent chapters in the UI instead of only the first or last three
- Add option for bookmarked chapters to download dropdown
- Add missing indexes to improve database query performance
- Add `src:local` search alias for Local Source
- Add "src:" prefix to search by source ID
- Add Filters to Updates screen
- Add a small increment to chapter number before comparison to fix progress sync issues for Suwayomi
- Add authors/artists to MAL search results

### Changed
- Release v0.19.4
- Revert "Fix thread starvation caused by not yielding or using an inappropriate thread pool "
- Revert "Fix cache invalidation isn't done at startup "
- Translations update from Hosted Weblate
- Update dependency io.kotest:kotest-assertions-core to v6.1.4
- Translations update from Hosted Weblate
- Run automatic library updates even when connected to a VPN
- Going back now first clears search query on browse extension tab
- Update gradle/actions action to v5.0.2
- Update dependency io.coil-kt.coil3:coil-bom to v3.4.0
- Utilize tracker for library duplicate detection
- Optimize tracked library filter
- Translations update from Hosted Weblate
- Don't wrap an intent-chooser inside another intent-chooser
- Update actions/dependency-review-action action to v4.8.3
- Update moko to v0.26.0
- Update dependency com.google.firebase:firebase-bom to v34.9.0
- Update dependency org.junit.jupiter:junit-jupiter to v6.0.3
- Update dependency androidx.compose:compose-bom to v2026.02.00
- Update dependency androidx.activity:activity-compose to v1.12.4
- Update kotlin monorepo to v2.3.10
- Update paging.version to v3.4.1
- Update dependency io.kotest:kotest-assertions-core to v6.1.3
- Update dependency com.materialkolor:material-kolor to v5.0.0-alpha06
- Clean up some build warnings
- Update dependency androidx.compose:compose-bom to v2026.01.01
- Update gradle/actions action to v5.0.1
- Update dependency androidx.work:work-runtime to v2.11.1
- Update paging.version to v3.4.0
- Update dependency androidx.activity:activity-compose to v1.12.3
- Update markdown to v0.39.2
- Update dependency io.kotest:kotest-assertions-core to v6.1.2
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v8.2.1
- Update dependency io.mockk:mockk to v1.14.9
- Update serialization.version to v1.10.0
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v8.2.0
- Update dependency io.kotest:kotest-assertions-core to v6.1.1
- Update Gradle to v8.14.4
- Update GitHub Actions
- Reword download index message
- Update dependency io.kotest:kotest-assertions-core to v6.1.0
- Update dependency com.google.firebase:firebase-bom to v34.8.0
- Update dependency androidx.compose:compose-bom to v2026
- Update dependency com.materialkolor:material-kolor to v5.0.0-alpha05
- Update markdown to v0.39.1
- Update donation link
- Enable logcat logging on stable and debug builds without enabling verbose logging
- Translations update from Hosted Weblate
- Optimise MAL search queries by ~11x
- Update dependency org.junit.jupiter:junit-jupiter to v6.0.2
- Update dependency org.jsoup:jsoup to v1.22.1
- Remember descriptionAnnotator across composition
- Cleanup extension screen search query predicate
- Switch to M3E ExtendedFloatingActionButton
- Switch to MaterialExpressiveTheme
- Use materilalKolor for monet compat color scheme
- Implement automatic removal of downloads on Suwayomi after reading, configurable via extension settings
- Translations update from Hosted Weblate
- Update dependency androidx.compose:compose-bom to v2025.12.01
- Update markdown to v0.39.0
- Update aboutlib.version to v13.2.1
- Update dependency androidx.activity:activity-compose to v1.12.2
- Update kotlin monorepo to v2.3.0
- Minimize memory usage by reducing in-memory cover cache size
- Update GitHub Actions
- Update dependency com.google.firebase:firebase-bom to v34.7.0
- Use AGP provided NDK and Build Tools version
- Update dependency com.android.tools.build:gradle to v8.13.2
- Update tracker icons
- Update dependency androidx.activity:activity-compose to v1.12.1
- Update dependency io.mockk:mockk to v1.14.7
- Update GitHub Actions
- Update softprops/action-gh-release action to v2.5.0
- Update dependency io.kotest:kotest-assertions-core to v6.0.7
- Cleanup BaseOAuthLoginActivity and TrackLoginActivity
- Update dependency com.pinterest.ktlint:ktlint-cli to v1.8.0
- Update dependency androidx.activity:activity-compose to v1.12.0
- Update moko to v0.25.2
- Update sqlite to v2.6.2
- Update lifecycle.version to v2.10.0
- Update actions/checkout action to v6
- Update actions/checkout action to v5.0.1
- Update dependency com.squareup.okio:okio to v3.16.4
- Update dependency io.kotest:kotest-assertions-core to v6.0.5
- Update okhttp monorepo to v5.3.2
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v8.1.0
- Update dependency com.google.firebase:firebase-bom to v34.6.0
- Update okhttp monorepo to v5.3.1
- Update dependency com.squareup.okio:okio to v3.16.3
- Update dependency app.cash.sqldelight:sqlite-3-38-dialect to v2.2.1
- Translations update from Hosted Weblate
- Stop tap zones from triggering when scrolling is stopped by tapping
- Update actions/dependency-review-action action to v4.8.2
- Update sqldelight to v2.2.1
- Update dependency com.android.tools.build:gradle to v8.13.1
- Update softprops/action-gh-release action to v2.4.2
- Translations update from Hosted Weblate

### Fixed
- Fix extension install/update stuck at pending
- Fix migration dialog not showing for consecutive prompts from the same screen
- Fix migration's selected sources order not preserved
- Fix cache invalidation isn't done at startup
- Fix thread starvation caused by not yielding or using an inappropriate thread pool
- Fix Add Repo input not taking up the full dialog width
- Fix memoization in manga bottom action menus
- Fix crash when trying to install/update extensions while shizuku isn't running
- Fix nullability of MAL authors breaking search
- Fix pre-1970 upload date display in chapter list
- Fix reader not saving read duration when changing chapter
- Fix mass migration not using the same search queries as individual migration
- Fix shizuku installer not updating installed extensions

### Removed
- Remove redundant `userSelected` from selection methods

## [0.19.3] - 2025-11-07

### Changed
- Revert "Fix reader tap zones triggering after scrolling was stopped by the user"
- Translations update from Hosted Weblate
- Improve WebView multi-window UX
- Update dependency androidx.core:core-splashscreen to v1.2.0
- Upload test report as artifact on failure
- Release v0.19.3
- Revert "Update dependency androidx.compose:compose-bom to v2025.10.01 "
- Translations update from Hosted Weblate
- Update dependency androidx.compose:compose-bom to v2025.10.01

### Fixed
- Fix extra padding appearing in reader after user interactions
- Fix flaky migration tests
- Fix long strip reader not scrolling on consecutive taps
- Fix WebView crash introduced in v0.19.2

## [0.19.2] - 2025-11-03

### Added
- Added proper multi window support in WebView instead of treating everything as a redirect
- Add option to customize concurrent downloads, increase page concurrency
- Add subtitle support to slider preference and general cleanup

### Changed
- Translations update from Hosted Weblate
- Migrated to the Android specific about libraries gradle plugin
- Handle reader cutout setting with Insets to support Android 15+
- Release v0.19.2
- Translations update from Hosted Weblate
- Make reader edge-to-edge
- Update Suwayomi tracker to use GraphQL API instead of REST API
- Update markdown to v0.38.1
- Update shizuku.version to v13.1.5
- Bump app version code and default user agent
- Update dependency org.junit.jupiter:junit-jupiter to v6.0.1
- Migrate Kitsu to use library_id and remote_id properly
- Update okhttp monorepo to v5.3.0
- Update plugin google-services to v4.4.4
- Update GitHub Actions (major)
- Update dependency androidx.work:work-runtime to v2.11.0
- Update dependency com.squareup.okio:okio to v3.16.2
- Update GitHub Actions
- Update dependency com.google.firebase:firebase-bom to v34.5.0
- Update xml.serialization.version to v0.91.3
- Update kotlin monorepo to v2.2.21
- Update dependency io.kotest:kotest-assertions-core to v6.0.4
- Update aboutlib.version to v13 (major)
- Update okhttp monorepo to v5.2.1
- Improve handling of downloads for chapters with same metadata and optionally for OSes that don't support Unicode in filename
- Update okhttp monorepo to v5.2.0
- Update softprops/action-gh-release action to v2.4.0
- Update dependency com.google.firebase:firebase-bom to v34.3.0
- Update gradle/actions action to v5
- Update GitHub Actions
- Update dependency org.junit.jupiter:junit-jupiter to v6
- Update moko to v0.25.1
- Update dependency io.mockk:mockk to v1.14.6
- Update markdown to 0.37.0
- Update kotlin monorepo to v2.2.20
- Update dependency androidx.work:work-runtime to v2.10.5
- Update sqlite to v2.6.1
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v8
- Improve spoofing of `X-Requested-With` header to support newer WebView versions
- Delegate Suwayomi tracker authentication to extension
- Update lifecycle.version to v2.9.4
- Update sqlite to v2.6.0
- Update dependency androidx.core:core-ktx to v1.17.0
- Update dependency androidx.activity:activity-compose to v1.11.0
- Replace `compose-stable-marker` with `compose-runtime-annotation`
- Bump compile and target sdk
- Update dependency com.google.firebase:firebase-bom to v34.2.0
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.4.1
- Update dependency androidx.work:work-runtime to v2.10.4
- Update dependency androidx.compose:compose-bom to v2025.09.00
- Update lifecycle.version to v2.9.3
- Update dependency org.jsoup:jsoup to v1.21.2
- Update dependency io.kotest:kotest-assertions-core to v6.0.3
- Update GitHub Actions
- Update dependency com.android.tools.build:gradle to v8.13.0
- Update plugin firebase-crashlytics to v3.0.6
- Update actions/setup-java action to v5
- Update dependency com.github.skydoves:compose-stable-marker to v1.0.7
- Bump targetSdk to 35
- Update actions/dependency-review-action action to v4.7.2
- Update dependency com.android.tools.build:gradle to v8.12.1
- Update dependency sh.calvin.reorderable:reorderable to v3
- Update dependency io.kotest:kotest-assertions-core to v6
- Switch to a fork of QuickJS Java
- Update kotlin monorepo to v2.2.10
- Update actions/checkout action to v5
- Don't hardcode app name in `strings.xml`

### Fixed
- Fix reader tap zones triggering after scrolling was stopped by the user
- Fix date picker not allowing the same start and finish date in negative time zones
- Fix CHANGELOG.md
- Fix scrollbar not showing when animator duration scale animation is turned off
- Fix extension download stuck at pending state in some cases
- Fix reader "Unable to edit key" error
- Fix migration "Attempt to invoke virtual method" crash
- Fix migration dialog migrating to wrong entry
- Fix mass migration advanced search query building
- Fix disabling incognito mode from notification
- Fix migration progress not updating and category flag mischeck
- Fix height of description not being calculated correctly if images are present
- Fix readme CI badge

## [0.19.1] - 2025-08-07

### Added
- Add label to privately installed extensions

### Changed
- Release v0.19.1
- Tweak build and release actions
- Move changelog unreleased removed section
- Revert "Add full predictive back support "
- Translations update from Hosted Weblate
- Use `ComicInfo.xml` for chapter metadata in localSource
- Update gradle/actions action to v4.4.2

### Fixed
- Fix crash opening filter sheet with empty library and mark as read/unread for selected items
- Fix 'Default' category showing in library with no user-added categories
- Fix title text color in light mode on mass migration list
- Fix local source EPUB files not loading
- Fix CHANGELOG.md v0.19.0 hyperlink and update release body template
- Fixed scrollbar sometimes not showing during scroll or not reaching the bottom with few items

### Removed
- Remove gradle toolchains plugin

## [0.19.0] - 2025-08-04

### Added
- Add donate link in more tab
- Support mass migration in 'Browse -> Migrate'
- Support mass migration for selected library items
- Add option for rendering images in description
- Add option to hide missing chapter count
- Add more migration config options and remove skipping option
- Add option to skip migration config
- Add Catppuccin theme
- Add migration config screen to select and prioritize target sources
- Add full predictive back support
- Add advanced option to always update manga title from source
- Add autofill support to tracker login dialog and update processing text
- Add option to keep read manga when clearing database
- Add markdown support for manga descriptions
- Add user manga notes
- Add more Kaomoji for empty/error screens

### Changed
- Release v0.19.0
- Update CHANGELOG.md
- Potentially fix library `IndexOutOfBound` crash
- Optimize and cleanup library code
- Update dependency com.android.tools.build:gradle to v8.12.0
- Update dependency androidx.test.ext:junit-ktx to v1.3.0
- Update dependency androidx.test.espresso:espresso-core to v3.7.0
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.4.0
- Update dependency androidx.work:work-runtime to v2.10.3
- Include Manga `initialized` status in backup
- Update dependency androidx.compose:compose-bom to v2025.07.00
- Update okhttp monorepo to v5.1.0
- Update kotlin monorepo to v2.2.0
- Update dependency org.jsoup:jsoup to v1.21.1
- Update dependency com.squareup.okio:okio to v3.16.0
- Update plugin firebase-crashlytics to v3.0.5
- Update dependency com.google.firebase:firebase-bom to v34
- Make local source default chapter sorting match file explorer behavior
- Update dependency com.squareup.logcat:logcat to v0.4
- Update xml.serialization.version to v0.91.2
- Update dependency com.squareup.logcat:logcat to v0.3
- Update dependency com.pinterest.ktlint:ktlint-cli to v1.7.1
- Update dependency io.coil-kt.coil3:coil-bom to v3.3.0
- Update lifecycle.version to v2.9.2
- Update dependency io.mockk:mockk to v1.14.5
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v7.2.1
- Update dependency org.junit.jupiter:junit-jupiter to v5.13.4
- Update dependency com.android.tools.build:gradle to v8.11.1
- Use median to determine smart update interval
- Update dependency com.squareup.okio:okio to v3.15.0
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v7.1.0
- Update serialization.version to v1.9.0
- Update dependency org.junit.jupiter:junit-jupiter to v5.13.3
- Update dependency gradle to v8.14.3
- Update aboutlib.version to v12.2.4
- Update moko to v0.25.0
- Update plugin google-services to v4.4.3
- Update dependency com.google.firebase:firebase-bom to v33.16.0
- Update dependency com.android.tools.build:gradle to v8.11.0
- Update dependency org.junit.jupiter:junit-jupiter to v5.13.2
- Update dependency io.mockk:mockk to v1.14.4
- Update manga without chapters even if restricted by source
- Update dependency com.mohamedrejeb.richeditor:richeditor-compose to v1.0.0-rc13
- Update dependency androidx.compose:compose-bom to v2025.06.01
- Update dependency androidx.work:work-runtime to v2.10.2
- Update dependency com.squareup.okio:okio to v3.13.0
- Update aboutlib.version to v12.2.3
- Update sqlite to v2.5.2
- Ensure app waits for Cloudflare challenge to complete before continuing
- Mass migration implementation
- Update gradle/actions action to v4.4.1
- Further tweak migration config screen sheet
- Update softprops/action-gh-release action to v2.3.2
- Update aboutlib.version to v12.2.2
- Update dependency sh.calvin.reorderable:reorderable to v2.5.1
- Update dependency sh.calvin.reorderable:reorderable to v2.5.0
- Update dependency com.google.firebase:firebase-bom to v33.15.0
- Update plugin firebase-crashlytics to v3.0.4
- Update dependency gradle to v8.14.2
- Update okhttp monorepo to v5.0.0-alpha.16
- Update sqldelight to v2.1.0
- Update dependency org.junit.jupiter:junit-jupiter to v5.13.1
- Update dependency androidx.compose:compose-bom to v2025.06.00
- Update dependency com.squareup.logcat:logcat to v0.2.3
- Update dependency androidx.appcompat:appcompat to v1.7.1
- Update lifecycle.version to v2.9.1
- Update aboutlib.version to v12.2.1
- Update dependency me.zhanghai.android.libarchive:library to v1.1.6
- Cleanup migrate manga dialog and related code
- Update dependency com.github.requery:sqlite-android to v3.49.0
- Update aboutlib.version to v12.2.0
- Update dependency com.android.tools.build:gradle to v8.10.1
- Update markdown to v0.35.0
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v7.0.4
- Update dependency com.squareup.okio:okio to v3.12.0
- Update dependency me.zhanghai.android.libarchive:library to v1.1.5
- Update dependency androidx.compose:compose-bom to v2025.05.01
- Update dependency gradle to v8.14.1
- Update plugin org.gradle.toolchains.foojay-resolver-convention to v1
- Update dependency com.pinterest.ktlint:ktlint-cli to v1.6.0
- Update xml.serialization.version to v0.91.1
- Update gradle/actions action to v4.4.0
- Update kotlin monorepo to v2.1.21
- Update dependency org.jetbrains.kotlinx:kotlinx-collections-immutable to v0.4.0
- Update actions/dependency-review-action action to v4.7.1
- Update dependency io.coil-kt.coil3:coil-bom to v3.2.0
- Disable reader's 'Keep screen on' setting by default
- Update CHANGELOG.md
- Update markdown to v0.34.0
- Update voyager to v1.1.0-beta03
- Update actions/dependency-review-action action to v4.7.0
- Update lifecycle.version to v2.9.0
- Update sqlite to v2.5.1
- Update dependency androidx.compose:compose-bom to v2025.05.00
- Update dependency com.android.tools.build:gradle to v8.10.0
- Update aboutlib.version to v12.1.2
- Cleanup MarkdownRender
- Update dependency androidx.compose:compose-bom to v2025.04.01
- Update aboutlib.version to v12.1.0
- Update dependency io.mockk:mockk to v1.14.2
- Update dependency org.jsoup:jsoup to v1.20.1
- Update aboutlib.version
- Switch default user agent to Android Chrome
- Update dependency com.google.firebase:firebase-bom to v33.13.0
- Update dependency androidx.work:work-runtime to v2.10.1
- Update dependency gradle to v8.14
- Update dependency com.android.tools.build:gradle to v8.9.2
- Update aboutlib.version to v12 (major)
- Update dependency com.mohamedrejeb.richeditor:richeditor-compose to v1.0.0-rc11
- Update markdown to 0.33.0 and tweak visuals
- Update softprops/action-gh-release action to v2.2.2
- Update Facebook and Reddit icon
- Replace Modifier.composed with Composable Modifier
- Include source headers when opening failed images from reader
- Use simpler markdown flavour in manga description
- Surface image loading error in Reader
- Change `Page.State` to sealed interface
- Update dependency androidx.core:core-ktx to v1.16.0
- Update plugin org.gradle.toolchains.foojay-resolver-convention to v0.10.0
- Update markdown to v0.33.0-rc01
- Update dependency androidx.compose:compose-bom to v2025.04.00
- Update dependency com.squareup.okio:okio to v3.11.0
- Update dependency io.mockk:mockk to v1.14.0
- Update dependency androidx.sqlite:sqlite-framework to v2.5.0
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v7.0.3
- Update dependency org.jetbrains.kotlinx:kotlinx-coroutines-bom to v1.10.2
- Update actions/setup-java action to v4.7.1
- Only enable telemetry in Mihon production apps
- Display total chapters on duplicates list items
- Update dependency androidx.compose:compose-bom to v2025.03.01
- Update non-library manga data when browsing
- Update xml.serialization.version to v0.91.0
- Display all similarly named duplicates in duplicate manga dialogue
- Deduplicate entries when browsing
- Update serialization.version to v1.8.1
- Switch readme download link to website
- Update actions/dependency-review-action action to v4.6.0
- Significantly improve browsing speed (near instantaneous)
- Update kotlin monorepo to v2.1.20
- Update dependency com.android.tools.build:gradle to v8.9.1
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.3.4
- Update editor config for 'sq' and 'sqm' file
- Update gradle/actions action to v4.3.1
- Update dependency com.google.firebase:firebase-bom to v33.11.0

### Fixed
- Fix same manga check logic in mass migration
- Fix superfluous string concat
- Fix background crash in mass migration screen
- Fix no sources while migrating alongside UI and code cleanup
- Fix content cut off in home screen
- Fix pressing `Enter` while searching also triggering navigation back on physical keyboards
- Fix downloader stopping after failing to create download directory of a manga
- Fix Pill not following the local text style
- Fix empty layout not appearing in browse source screen in some cases
- Fix crash when trying use source sort filter without a pre-selection
- Fix content under source browse screen top appbar is interactable
- Fix labels not applying on issues and rearrange them
- Fix reader not updating progress
- Fix duplicate requests in WebView due to empty reasonPhrase
- Fix navigation issue after migrating a duplicated entry from History tab
- Fix unintended app permissions due to Firebase misconfiguration
- Fix app bar action tooltips blocking clicks
- Fix mark existing duplicate read chapters as read option not working in some cases
- Fix user notes not restoring when manga doesn't exist in DB
- Fix page number not appearing when opening chapter
- Fix benchmark build
- Fix backup sharing from notifications not working when app is in background
- Fix next chapter button occasionally jumping to the last page of the current chapter
- Fix Bangumi search including novels

### Removed
- Remove checksum from release notes and improve download tip
- Remove Okhttp networking from WebView Screen
- Remove feature flag from Nord theme

## [0.18.0] - 2025-03-19

### Added
- Add missing references to CHANGELOG.md
- Add back option to hide unread chapter badge in library
- Add back build tools version to sign-android-release
- Add prefix search to search by internal DB ID
- Add app ID to debug info
- Add build tool version to android config
- Add option to mark new duplicate read chapters as read
- Add back support for drag-and-drop category reordering
- Add Xiaomi system app to list of invalid browsers
- Add option to export minimal library information to a CSV file
- Add private tracking support for Kitsu
- Support for private tracking with AniList and Bangumi
- Add back explicit update(track) call to Bangumi
- Add "Monochrome" theme
- Add button to favorite manga from history screen
- Add more editor configs and move ktlint config to it
- Add Infinix system app to list of invalid browsers
- Add zoned "Current time" to debug info and include year & timezone in logcat output
- Address some deprecations
- Add option to enable incognito mode per extension

### Changed
- Release v0.18.0
- Translations update from Hosted Weblate
- Update actions/upload-artifact action to v4.6.2
- Use current time as build time for preview builds
- Change 'include-analytics' to 'include-telemetry'
- Translations update from Hosted Weblate
- For release builds use last commit time as build time
- Seperate mark duplicate read chapters as read behaviors as options
- Tweak the app updater logic and add FOSS build support
- Update dependency org.jsoup:jsoup to v1.19.1
- Update dependency androidx.compose:compose-bom to v2025.03.00
- Rework website update workflow
- Move firebase stuff to a standalone module
- Make option to mark duplicate chapter as read apply when reading
- Make more sliders discrete and ensure they don't look out of place
- Change foss variant application id suffix to '.foss' and more
- Change label of setting to always use SSIV in long strip reader
- Bump default user agent
- Attempt to fix crash when migrating or removing entries from library
- Display staff information on Anilist tracker search results
- Update dependency com.android.tools.build:gradle to v8.9.0
- Update track search preview
- Tweak and adjust issue template
- Update dependency io.mockk:mockk to v1.13.17
- Only update website on new release
- Update website when a new version is released
- Spoof or remove `X-Requested-With` header from webview
- Update dependency com.google.firebase:firebase-bom to v33.10.0
- Update Issue Request Template
- Set explicit runner version and specify build tools version for signing
- Update dependency com.android.tools.build:gradle to v8.8.2
- Update dependency androidx.activity:activity-compose to v1.10.1
- Update dependency androidx.constraintlayout:constraintlayout to v2.2.1
- Stop showing divider when analytics is not included
- SpotlessApply imports of 0dda64b9d80a47a96fb52d13b5e0ece6d5fca2b1
- Use `.toUri()` extension function
- Move google-services.json file to app module root
- Rework build variants and add FOSS variant
- Update dependency gradle to v8.13
- Update dependency com.android.tools:desugar_jdk_libs to v2.1.5
- Migrate to Bangumi's newer v0 API
- Update dependency androidx.compose:compose-bom to v2025
- Format CHANGELOG.md
- Reuse `AppBar` in manga screen
- Cleanup and tweak preference widgets
- Apply "Downloaded only" filter to all entries regardless of favourite status
- Update aboutlib.version to v11.6.3
- Update actions/upload-artifact action to v4.6.1
- Ignore hidden files/folders for Local Source chapter list
- Update aboutlib.version to v11.6.0
- Update plugin firebase-crashlytics to v3.0.3
- Update dependency com.android.tools.build:gradle to v8.8.1
- Update paging.version to v3.3.6
- Update dependency io.coil-kt.coil3:coil-bom to v3.1.0
- Update moko to v0.24.5
- Update GitHub Actions
- Rework slider UI
- Update aboutlib.version to v11.5.0
- Update dependency gradle to v8.12.1
- Update kotlin monorepo to v2.1.10
- Update dependency com.google.firebase:firebase-bom to v33.8.0
- Update dependency androidx.recyclerview:recyclerview to v1.4.0
- Update dependency androidx.activity:activity-compose to v1.10.0
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v7.0.2
- Update GitHub Actions
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v7.0.1
- Update dependency com.squareup.okio:okio to v3.10.2
- Update dependency com.android.tools.build:gradle to v8.8.0
- Update dependency io.mockk:mockk to v1.13.16
- Use Adoptium distributed Java in workflows
- Update dependency com.diffplug.spotless:spotless-plugin-gradle to v7.0.0
- Update serialization.version to v1.8.0
- Update aboutlib.version to v11.4.0
- Tweak build workflows
- Update GitHub Actions
- Use `secrets.GITHUB_TOKEN` for release
- Revert "Revert "Add option to always use SSIV for image decoding""
- Update dependency gradle to v8.12
- Update dependency androidx.compose:compose-bom to v2024.12.01
- Update paging.version to v3.3.5
- Update dependency androidx.viewpager:viewpager to v1.1.0
- Update dependency org.junit.jupiter:junit-jupiter to v5.11.4
- Update voyager to v1.0.1
- Update dependency com.android.tools:desugar_jdk_libs to v2.1.4
- Update dependency org.jetbrains.kotlinx:kotlinx-coroutines-bom to v1.10.1
- Update dependency io.mockk:mockk to v1.13.14
- Migrate renovate config
- Update moko-resources to v0.24.4
- Update dependency com.google.firebase:firebase-bom to v33.7.0
- Update dependency com.android.tools.build:gradle to v8.7.3
- Update dependency com.pinterest.ktlint:ktlint-cli to v1.5.0
- Update dependency org.jsoup:jsoup to v1.18.3
- Update kotlin monorepo to v2.1.0
- Update CHANGELOG.md

### Fixed
- Fix firebase telemetry implementation package
- Fix analytics/crashlytics configuration not being set after fe22f5a
- Fix website repo API url in workflow
- Fix an issue where tracker reading progress is changed to a lower value
- Fix webview crash caused by 793d7fb
- Fix APK paths in workflows
- Fix Bangumi login regression
- Fix backup/restore of category related preferences
- Fix App's preferences referencing deleted categories
- Fix MAL tracker losing track of login expiration
- Fix Bangumi tracker losing track of login expiration
- Fix MAL `main_picture` nullability breaking search if a result doesn't have a cover set

### Removed
- Remove closed issue/pr auto lock workflow
- Remove alphabetical category sort option
- Remove F-droid warnings
- Remove unnecessary filters for pseudolocales

## [0.17.1] - 2024-12-06

### Added
- Add a Honor system app to list of invalid browsers
- Add option to lower the threshold for hardware bitmaps
- Add option to always use SSIV for image decoding
- Address some build warnings and cleanup

### Changed
- Release v0.17.1
- Replace project icon
- Translations update from Hosted Weblate
- Always use software bitmap on certain devices
- Update GitHub Actions
- Update CHANGELOG.md
- Translations update from Hosted Weblate
- Update dependency org.jsoup:jsoup to v1.18.2
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.4
- Update dependency gradle to v8.11.1
- Improve hardware bitmap threshold option
- Slightly tweak Preference.PreferenceItem.CustomPreference
- Switch to hardware bitmap in reader only if device can handle it
- Revert "Add option to always use SSIV for image decoding"
- Update paging.version to v3.3.4
- Update dependency androidx.viewpager:viewpager to v1.1.0-rc01
- Update GitHub Actions
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.3
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.2
- Update dependency androidx.work:work-runtime to v2.10.0
- Update dependency com.android.tools:desugar_jdk_libs to v2.1.3
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.1
- Update dependency com.pinterest.ktlint:ktlint-cli to v1.4.1
- Update dependency androidx.compose:compose-bom to v2024.10.01
- Update dependency androidx.core:core-ktx to v1.15.0
- Update dependency com.android.tools.build:gradle to v8.7.2
- Update softprops/action-gh-release action to v2.0.9
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.0
- Update xml.serialization.version to v0.90.3
- Cleanup some code
- Update organization name in readme license snippet
- Translations update from Hosted Weblate
- Auto format extension repo URLs
- Bump default user agent
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.0-rc02
- Update actions/dependency-review-action action to v4.4.0
- Update dependency androidx.constraintlayout:constraintlayout to v2.2.0
- Update lifecycle.version to v2.8.7
- Some improvements to Bangumi tracker search
- Update dependency androidx.annotation:annotation to v1.9.1
- Update dependency androidx.viewpager:viewpager to v1.1.0-beta01
- Switch to spotless 7.0.0 Beta 4
- Here lies "currentTab was used multiple times"

### Fixed
- Fix app update error notification disappearing
- Fix loading screen not appearing when changing query in browser screen
- Fix reader transition color scheme in auto background mode
- Fix crash after removing last category while it's active in library
- Fix long strip images not loading in some old devices
- Fix a rare crash when invoking "Mark previous as read" action
- Fix sporadically recurring spotless CI failure

## [0.17.0] - 2024-10-26

### Added
- Add libs.material to presentation-widget
- Address deprecation, suggestion and spotless
- Add option to backup non-library read entries
- Added random library sort
- Add Quantity Badge to Upcoming Screen
- Add option to opt out of Analytics and Crashlytics
- Add crashlytics to standard builds
- Add stable marker to Manga data class
- Add "show entry" action to download notifications
- Add confirmation when adding repo via URI
- Add option to skip downloading duplicate read chapters
- Add PR or commit refs to CHANGELOG.md
- Address spotless lint errors
- Add spotless (with ktlint)
- Add comment about RecyclerView cache size
- Add an "open in browser" button to reader menu
- Add a button to select all scanlators
- Add Copy Tracker URL on icon long press
- Add Backup and Restore of Extension Repos
- Adds Option to Copy Panel to Clipboard
- Add safeguard to prevent ArchiveInputStream from being closed twice
- Added configuration options to e-ink page flashes
- Address firebase ktx module deprecation
- Add MyAnimeList issue autoclose
- Add ProGuard rule to keep mihon namespace classes
- Add reference to compose compiler in `compose.versions.toml` so renovate can catch it
- Address detekt issues
- Db changes to accommodate new cross device syncing logic.
- Address `ZipFile` deprecation warning
- Address `overridePendingTransition` deprecation
- Add Dependencies label to Renovate Dependencies

### Changed
- Release v0.17.0
- Update CHANGELOG.md
- Allow completely disabling "Update tracker" snackbar on mark as read
- Update dependency com.pinterest.ktlint:ktlint-cli to v1.4.0
- Update actions/setup-java action to v4.5.0
- Cleanup Slider usage
- Update dependency me.zhanghai.android.libarchive:library to v1.1.4
- Avoid blocking call to load categories in settings
- Rework Auto Track on Mark as Read
- Pin actions/upload-artifact action to b4b15b8
- Make renovate group github action deps
- Update actions/checkout action to v4.2.2
- Update actions/dependency-review-action action to v4.3.5
- Update dependency com.google.firebase:firebase-bom to v33.5.1
- Update shizuku.version to v13.1.0
- Update dependency com.google.firebase:firebase-bom to v33.5.0
- Update dependency org.junit.jupiter:junit-jupiter to v5.11.3
- Pass uncaught exception to default handler in GlobalExceptionHandler
- Rework Firebase setup
- Revert "Tweak Preference.collectAsState"
- Update dependency androidx.compose:compose-bom to v2024.10.00
- Update xml.serialization.version to v0.90.2
- Change "Invalidate downloads index" to "Reindex downloads"
- Update dependency androidx.annotation:annotation to v1.9.0
- Update dependency androidx.glance:glance-appwidget to v1.1.1
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.3.3
- Update dependency androidx.activity:activity-compose to v1.9.3
- Update i18n readme
- Update dependency com.android.tools.build:gradle to v8.7.1
- Make sure random library sort is at the bottom
- Reorder reader menu overflow items
- Cleanup .gitignore files
- Adjust expandable fab animation
- Refrain from running spotless on weblate files
- Run PR check when base strings are changed
- Confirmation dialog when removing privately installed extensions
- Update dependency me.zhanghai.android.libarchive:library to v1.1.3
- Tweak profile compilation status output
- Dispatch page change only when needed
- Bump compile sdk to 35
- Update resources exclusion rules
- Adjust distinct checker in WidgetManager and run on default dispatcher
- Tweak Preference.collectAsState
- Cleanup `LibraryScreenModel` `LibraryMap.applySort` and some more
- Update kotlin monorepo to v2.0.21
- Retain remote last chapter read if it's higher than the local one for EnhancedTracker
- Update dependency io.mockk:mockk to v1.13.13
- Update renovate configuration
- Update actions/checkout action to v4.2.1
- Update dependency gradle to v8.10.2
- Update actions/checkout action to v4.2.0
- Update actions/setup-java action to v4.4.0
- Change casing for Extention Repos String
- Move firebase permission removal to standard flavor
- Re-enable fetching chapters list for entries with licenced status
- Update gradle/actions action to v4.1.0
- Update actions/setup-java action to v4.3.0
- Update dependency gradle to v8.10.1
- Use new library for injekt with inorichi patch
- Show toast for app restart when User-Agent is changed
- Bump NDK version
- Reduce ChapterNavigator horizontal padding on small ui
- Use TextFieldState in BasicTextField where applicable
- Use uy.kohesive.injekt instead of com.github.inorichi.injekt
- `spotlessApply` my beloved
- Ignore "intent://" urls on webview
- Switch to stable compose
- Move archive related code to :core:archive
- Rename LocalesConfigPlugin file to LocalesConfigTask
- Migrate some classpaths to gradle plugins
- Option to update trackers when chapter marked as read
- Enable 'Split Tall Images' by default
- Use DTOs to parse tracking API responses
- `spotlessApply` my beloved
- Collect MangaScreen state with lifecycle
- PagerPageHolder: lazy init loading indicator
- Use feature flags in compose compiler plugin
- Hide keyboard when a Tracker SearchResultItem is clicked
- Update gradle/actions action to v4.0.1
- Respect privacy settings in extension update notification
- Update kotlin monorepo to v2.0.20
- Translations update from Hosted Weblate
- Generate locales_config.xml in build dir
- Update dependency gradle to v8.10
- Sync compose theme with MDC theme
- Update CHANGELOG.md
- Create CHANGELOG.md
- Handle Android SDK 35 API collision
- Translations update from Hosted Weblate
- Change Kitsu to kitsu.app domain
- KtLintFormat -> detekt
- Update gradle/actions action to v4
- ExpandableMangaDescription: Adjust size transform anim spec
- Rename backup restore error log file
- Update kotlin monorepo to v2.0.10
- Don't crash on ill-formed URLs
- Update actions/setup-java action to v4.2.2
- Match extra layout space with scroll distance
- Improve error message if restoring from JSON file
- Bump default user agent string
- Cleanup backup/restore related code
- Format Category String on Subtitle Display
- Update softprops/action-gh-release action to v2.0.8
- Update gradle/actions action to v3.5.0
- Update dependency gradle to v8.9
- Update actions/dependency-review-action action to v4.3.4
- A Minor Milestone
- Bump coil version and some cleanup
- Observe tracker login state instead of fetching once
- Make global search "Has result" sticky
- Smart Update Dialog Tweak
- Correct tako variable colours
- Update image-decoder revision
- Theme fixes
- Fix strange warning in ci build
- Refactor archive support with libarchive
- Upload build artifacts
- Cleanup in `CommonMangaItem.kt`
- Update `build_pull_request.yml` `paths-ignore`
- Translations update from Hosted Weblate
- Update softprops/action-gh-release action to v2.0.6
- Update gradle/actions action to v3.4.2
- Update R8 to fix `NoSuchMethodError` crash
- Update gradle/actions action to v3.4.1
- Update gradle/actions action to v3.4.0
- Translations update from Hosted Weblate
- Migrate to `gradle/actions/wrapper-validation`
- Update actions/checkout action to v4.1.7
- Check category order before restoring from backup
- Translations update from Hosted Weblate
- Don't use alpha modifier
- Update kotlin and compose compiler to v2 (major)
- Update actions/dependency-review-action action to v4.3.3
- Update dependency gradle to v8.8
- Update kotlin and compose compiler
- Update actions/checkout action to v4.1.6
- Update renovate config
- Update themes to follow new compose update changes
- Update r8 rules for `MultipartBody.Builder` in extensions
- Update softprops/action-gh-release action to v2.0.5
- Update actions/checkout action to v4.1.5
- Update project icon
- Use new SurfaceContainer color roles
- Change keyboard type in extension repo dialog
- Revert "Fix badge count getting cut off on tab title"
- Bump compose version
- Massively improve findFile performance
- Trust extension by repo
- Revert "fix(deps): update dependency androidx.compose.compiler:compiler to v1.5.13 "
- Update actions/dependency-review-action action to v4.3.2
- Log app crash exceptions in dumped crash logs
- Update subsampling-scale-image-view
- Use Coil pipeline instead of SSIV for image decode
- Revert "fix(deps): update dependency dev.chrisbanes.compose:compose-bom to v2024.04.00-alpha02 "
- Update gradle/wrapper-validation-action action to v3.3.2
- Update gradle/actions action to v3.3.2
- Update actions/checkout action to v4.1.4
- Update gradle/wrapper-validation-action action to v3.3.1
- Update gradle/actions action to v3.3.1
- Use Okio instead of `java.io` for image processing
- Use m3 ripple and clean up interactionSource usage
- Update compose bom and fix renovate config for it
- Update gradle/actions action to v3.3.0
- Update gradle/wrapper-validation-action action to v3
- Update gradle/wrapper-validation-action action to v2.1.3
- Update aboutlib.version to v11.1.3
- Update dependency com.android.tools.build:gradle to v8.3.2
- Update gradle/actions action to v3.2.1
- Merge branch 'release/v0.16.5'
- Revert "Update Scaffold fork " + Cleanup
- Small cleanups
- Rework buildSrc and remove usage of subprojects
- Disable mpp and agp compability warning
- Update gradle/actions action to v3.2.0
- Translations update from Hosted Weblate
- Translations update from Hosted Weblate
- Moves upcoming requirement from existence to current day or later.
- Update actions/dependency-review-action action to v4.2.5
- New Feature: Introduce Upcoming page to Mihon
- Migrator improvements
- Rewrite Migrations
- Refactor the ExtensionRepoService to use DTOs
- Migrated from Accompanist Webview to KevinZou WebView
- Grab extension repo detail from `repo.json` and include in DB
- Update dependency gradle to v8.7
- Update kotlin
- Rework Duplicate Dialog and Allow Migration
- Update gradle/wrapper-validation-action action to v2.1.2
- Update actions/dependency-review-action action to v4.2.3
- Update image-decoder, color management
- Switch to seconds for DATE_MODIFIED of saved pages
- Typo in `r0adkll/sign-android-release` SHA
- Check for dependency update every Friday
- Use SHA for GitHub actions version
- Disable `SerialVersionUIDInSerializableClass` detekt rule
- Bump default user agent
- Update dependency io.nlopez.compose.rules:detekt to v0.3.12
- Translations update from Hosted Weblate
- Update image-decoder
- Small cleanup
- Update dependency com.android.tools.build:gradle to v8.3.0
- Update dependency io.mockk:mockk to v1.13.10
- Revert changes to gradle.properties
- `detekt` my beloved
- Update dependency me.saket.swipe:swipe to v1.3.0
- Switch to Coil3
- Enable experimental Compose compiler optimization
- Remove composed modifier usage
- Upgrade Compose
- Made some changes to ComicInfo metadata
- Revert "Update sqldelight to v2.0.1"
- Update Kotlin
- Update dependency io.coil-kt:coil-bom to v2.6.0
- Update dependency org.junit.jupiter:junit-jupiter to v5.10.2
- Update dependency com.google.firebase:firebase-analytics-ktx to v21.5.1
- Update dependency androidx.test.uiautomator:uiautomator to v2.3.0
- Update detekt to v1.23.5
- Update sqldelight to v2.0.1
- Merge branch 'release/v0.16.4'
- Don't add custom User Agent for MAL
- Update dependency com.squareup.okio:okio to v3.8.0
- Update dependency org.apache.commons:commons-compress to v1.26.0
- Allow disabling reader's zoom out
- Update dependency com.google.gms:google-services to v4.4.1
- Translations update from Hosted Weblate
- [ExtensionLoader] Prioritize extension classpath over app classpath
- Tweak detekt config
- Cleanup [BaseColorScheme.getColorScheme]
- Update gradle.properties
- Small cleanup in `WorkerInfoScreen`
- Revert a mishap in 7ff95e21babda98dd1b479912278d6029cd15f0d
- Ignore detekt [LongParameterList] for composables
- Refactor use of Java.util.date to Java.time.*, to fix localized date issues.
- Minor refactor of theming when expressions
- Update dependency androidx.test.ext:junit-ktx to v1.2.0-alpha03
- Update dependency androidx.test.espresso:espresso-core to v3.6.0-alpha03
- Update lifecycle.version to v2.7.0
- Update dependency com.github.requery:sqlite-android to v3.45.0
- Update dependency io.github.fornewid:material-motion-compose-core to v1.2.0
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.2.3
- Tweak README.md
- Update dependency gradle to v8.6
- Don't copy archives to temp files when opening
- Update workflow dependencies

### Fixed
- Fix app crash when removing tracked entry from tracker
- Fix settings SliderItem steps count
- Fix PR build check
- Fix EnhancedTracker not auto binding when adding manga to library
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.0-rc01
- Fix AniList `ALSearchItem.status` nullibility
- Update dependency androidx.compose:compose-bom to v2024.09.03
- Update dependency org.junit.jupiter:junit-jupiter to v5.11.2
- Update dependency androidx.profileinstaller:profileinstaller to v1.4.1
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.3.2
- Update dependency com.google.firebase:firebase-bom to v33.4.0
- Update dependency com.android.tools.build:gradle to v8.7.0
- Update dependency androidx.compose:compose-bom to v2024.09.02
- Update dependency org.junit.jupiter:junit-jupiter to v5.11.1
- Update dependency me.zhanghai.android.libarchive:library to v1.1.2
- Update dependency androidx.profileinstaller:profileinstaller to v1.4.0
- Update lifecycle.version to v2.8.6
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.3.1
- Update serialization.version to v1.7.3
- Update dependency com.android.tools.build:gradle to v8.6.1
- Update dependency me.zhanghai.android.libarchive:library to v1.1.1
- Fix Kitsu `synopsis` nullability
- Fix WheelPicker Manual Input
- Wrong calculation of nextUpdate when setting custom fetchInterval
- Update dependency androidx.compose:compose-bom to v2024.09.01
- Update dependency com.google.firebase:firebase-bom to v33.3.0
- Update dependency com.squareup.okio:okio to v3.9.1
- Update dependency org.jetbrains.kotlinx:kotlinx-coroutines-bom to v1.9.0
- Update dependency org.jetbrains.kotlinx:kotlinx-collections-immutable to v0.3.8
- Update dependency androidx.activity:activity-compose to v1.9.2
- Update dependency com.google.accompanist:accompanist-systemuicontroller to v0.36.0
- Update lifecycle.version to v2.8.5
- Fix Kitsu `ratingTwenty` being typed as String
- Update dependency com.android.tools:desugar_jdk_libs to v2.1.2
- Fix mishap in 02af9b1acf9f590d29560bc3fc90d206e8e6e1af
- Update dependency com.android.tools.build:gradle to v8.6.0
- Update dependency com.android.tools:desugar_jdk_libs to v2.1.1
- Update serialization.version to v1.7.2
- Update dependency com.android.tools:desugar_jdk_libs to v2.1.0
- Update aboutlib.version to v11.2.3
- Update moko to v0.24.2
- Update dependency dev.chrisbanes.compose:compose-bom to v2024.08.00-alpha02
- Update dependency com.google.firebase:firebase-analytics to v22.1.0
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.3.0
- Update dependency org.conscrypt:conscrypt-android to v2.5.3
- Update dependency org.junit.jupiter:junit-jupiter to v5.11.0
- Fix some migrations never running
- Fix UI freeze after migration
- Fix MAL search results not showing start dates
- Update dependency com.android.tools.build:gradle to v8.5.2
- Update dependency dev.chrisbanes.compose:compose-bom to v2024.08.00-alpha01
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.0-alpha10
- Update dependency androidx.work:work-runtime to v2.9.1
- Update dependency androidx.annotation:annotation to v1.8.2
- Update paging.version to v3.3.2
- DrawScrollbar crash on list with 0 item but only sticky header
- Fix library is backed up when disabled and make categories backup/restore independent
- Fix disappearance items when fast scrolling
- Update dependency dev.chrisbanes.compose:compose-bom to v2024.07.00-alpha02
- Update paging.version to v3.3.1
- Update lifecycle.version to v2.8.4
- Update dependency androidx.annotation:annotation to v1.8.1
- Update dependency androidx.activity:activity-compose to v1.9.1
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.0-alpha09
- Update dependency io.mockk:mockk to v1.13.12
- Update dependency org.jsoup:jsoup to v1.18.1
- Update dependency dev.chrisbanes.compose:compose-bom to v2024.07.00-alpha01
- Update dependency com.android.tools.build:gradle to v8.5.1
- Fix some issues when reading/saving images
- Fix login prompts despite being logged in to trackers in Manga screen
- Update lifecycle.version to v2.8.3
- Update dependency io.coil-kt.coil3:coil-bom to v3.0.0-alpha07
- Update aboutlib.version to v11.2.2
- Update dependency org.junit.jupiter:junit-jupiter to v5.10.3
- Update dependency androidx.test.espresso:espresso-core to v3.6.1
- Update dependency androidx.test.ext:junit-ktx to v1.2.1
- Update dependency dev.chrisbanes.compose:compose-bom to v2024.06.00-alpha01
- Update serialization.version to v1.7.1
- Update dependency androidx.test.ext:junit-ktx to v1.2.0
- Update dependency androidx.test.espresso:espresso-core to v3.6.0
- Fix Migrator test and also add the test to build script
- Fix unexpected skips in strong skipping mode
- Update dependency io.github.fornewid:material-motion-compose-core to v2.0.1
- Update dependency com.google.firebase:firebase-analytics to v22.0.2
- Update moko to v0.24.1
- Fix R8 version configuration not working
- Update dependency com.android.tools.build:gradle to v8.5.0
- Fix issue with creating and restoring backup
- Update dependency androidx.glance:glance-appwidget to v1.1.0
- Update lifecycle.version to v2.8.2
- Update dependency com.android.tools.build:gradle to v8.4.2
- Fix chapter number parsing when number is after unwanted tag
- Update dependency io.github.fornewid:material-motion-compose-core to v2
- Update okhttp monorepo to v5.0.0-alpha.14
- Update dependency dev.chrisbanes.compose:compose-bom to v2024.05.00-alpha03
- Update serialization.version to v1.7.0
- Update dependency io.kotest:kotest-assertions-core to v5.9.1
- Fix MigratorTest after update to io.mockk v1.13.11
- Update dependency io.github.fornewid:material-motion-compose-core to v1.2.1
- Storage permission request for non-conforming devices
- Update dependency androidx.test.ext:junit-ktx to v1.2.0-rc01
- Update aboutlib.version to v11.2.1
- Update dependency com.google.firebase:firebase-analytics to v22.0.1
- Update dependency com.google.gms:google-services to v4.4.2
- Update dependency androidx.test.espresso:espresso-core to v3.6.0-rc01
- Update dependency androidx.appcompat:appcompat to v1.7.0
- Update lifecycle.version to v2.8.1
- Update paging.version to v3.3.0
- Update dependency org.apache.commons:commons-compress to v1.26.2
- Update aboutlib.version to v11.2.0
- Update dependency com.android.tools.build:gradle to v8.4.1
- Update lifecycle.version to v2.8.0
- Update dependency androidx.annotation:annotation to v1.8.0
- Update dependency io.mockk:mockk to v1.13.11
- Update dependency androidx.test.ext:junit-ktx to v1.2.0-beta01
- Update dependency com.google.android.material:material to v1.12.0
- Update dependency dev.chrisbanes.compose:compose-bom to v2024.05.00-alpha02
- Fix renovate config
- Update dependency androidx.test.espresso:espresso-core to v3.6.0-beta01
- Update dependency org.jetbrains.kotlinx:kotlinx-coroutines-bom to v1.8.1
- Update dependency io.kotest:kotest-assertions-core to v5.9.0
- Fix tap control area shifting after zooming out
- Fix search bar style
- Fix badge count getting cut off on tab title
- Fix some extension related issue and cleanups
- Update leakcanary to v2.14
- Update dependency com.android.tools.build:gradle to v8.4.0
- Update dependency androidx.test.espresso:espresso-core to v3.6.0-alpha04
- Update dependency androidx.compose.compiler:compiler to v1.5.13
- Update dependency androidx.core:core-ktx to v1.13.1
- Update dependency androidx.test.ext:junit-ktx to v1.2.0-alpha04
- Update aboutlib.version to v11.1.4
- Update dependency dev.chrisbanes.compose:compose-bom to v2024.04.00-alpha02
- Update dependency androidx.compose.compiler:compiler to v1.5.12
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.2.4
- Update dependency androidx.activity:activity-compose to v1.9.0
- Update dependency androidx.core:core-ktx to v1.13.0
- Update dependency com.google.firebase:firebase-analytics-ktx to v21.6.2
- Fix build time zone in about screen
- Update sqldelight to v2.0.2
- Fix Migrator not doing work
- Update detekt to v1.23.6
- Update dependency io.github.kevinnzou:compose-webview to v0.33.6
- Update aboutlib.version to v11.1.1
- Fix mishap in e020ae5ed558e80742ef0ad8bfa0f69af0959d5a
- Fix more TypeReference issues and cleanup
- Fix extension repo crash with TypeReference issue
- Fix repo name used for URL instead of baseUrl
- Fix extension repo migration not triggering
- Update aboutlib.version to v11 (major)
- Fix webtoon last visible item position calculation
- Update dependency com.google.firebase:firebase-analytics-ktx to v21.6.1
- Fix recycled item's height being 0 in webtoon mode
- Update dependency org.apache.commons:commons-compress to v1.26.1
- Update dependency com.android.tools.build:gradle to v8.3.1
- Fix regression from coil3 migration
- Update dependency io.kotest:kotest-assertions-core to v5.8.1
- Update dependency com.squareup.okio:okio to v3.9.0
- Fix multiple issues regarding sources loading too late
- Fix crash in track date selection dialog
- Fix shizuku being buggy for multi user setups
- Fix dual page split for local source
- Fix ChapterDownloadIndicator
- Fix detekt issue
- Fix some issues from 7ff95e2
- Fix DelayedTrackingUpdateJob spam on update errors
- Fix extracting ComicInfo.xml files in local source

### Removed
- Remove usage of deprecated accompanist SystemUiController
- Remove more unnecessary permissions from Firebase dependency
- Remove legacy broken source and history backup
- Remove detekt
- Remove WebViewClientCompat
- Remove obsolete workaround
- remove unused github workflow
- Remove dependency on compose material 2 components
- Remove some legacy folder/file name lookup for download
- Remove unused imports
- Remove custom Pager

## [0.16.5] - 2024-04-09

### Added
- Address detekt issues

### Changed
- Release v0.16.5
- Update dependency gradle to v8.7
- Update image-decoder, color management
- Switch to seconds for DATE_MODIFIED of saved pages
- Disable `SerialVersionUIDInSerializableClass` detekt rule
- Upgrade Compose
- Tweak detekt config
- Revert a mishap in 7ff95e21babda98dd1b479912278d6029cd15f0d
- Ignore detekt [LongParameterList] for composables
- Refactor use of Java.util.date to Java.time.*, to fix localized date issues.

### Fixed
- Fix build time zone in about screen
- Fix crash in track date selection dialog
- Fix some issues from 7ff95e2
- Fix DelayedTrackingUpdateJob spam on update errors

### Removed
- Remove unused imports

## [0.16.4] - 2024-02-26

### Changed
- Release v0.16.4
- Don't add custom User Agent for MAL

### Fixed
- Fix detekt issue

## [0.16.3] - 2024-01-29

### Added
- Address build warning in `:i18n`
- Add click-to-copy extension debug info
- Adding Detekt in the project

### Changed
- Release v0.16.3
- Don't throw `MALTokenExpired` whenever we fail to refresh MAL token
- Increase size of the message indicating which apk to download
- Translations update from Hosted Weblate
- Lint
- Move `:core` to `:core:common`
- Delete ic_launcher-web.png
- Upgrade `combose-bom` to latest
- Update issue templates
- Update dependency com.android.tools.build:gradle to v8.2.2
- Change extension update error file name
- Hide display cutout setting if fullscreen is off

### Fixed
- Fix new extension install not registering in app.
- Fix #197 - Scroll crashing
- Fixing bottom sheet UI bug in non-tablet devices

### Removed
- Remove old `ISSUE_TEMPLATE.md`

## [0.16.2] - 2024-01-27

### Added
- Adding Type-safe project accessors
- Add translation widget

### Changed
- Release v0.16.2
- Translations update from Hosted Weblate
- Lint
- Refactor MAL code to not spam refresh token when it fails
- Update types of legacy tracker model to match to domain one
- Replace "tachiyomi" with "mihon" in crash log name
- Translations update from Hosted Weblate
- Removing extensions from config issues
- Change README to Markdown
- Lint
- Use own client for trackers + custom user agents
- Translations
- Tweak app icon scaling
- Backup and Restore Excluded scanlators
- Tweak README
- Modernize README
- Db changes for syncing.

### Fixed
- Fix refreshing from enhanced tracker
- Fix #126: Inconsistent button height with some languages in "Data and storage"
- Fix issues when updating extensions
- Fix faulty MangaUpdates score in db
- Fix "Flash on page change" gives black screen on page change

### Removed
- Remove official extensions check from issue templates
- Remove usage of `.not()` where possible

## [0.16.1] - 2024-01-17

### Changed
- Release v0.16.1
- Refer to the preview build as beta
- Update project icon
- Updated Issue and Feature Request templates
- Replace some more Tachiyomi reference
- Replaced mentions of Tachiyomi with Mihon in Issue Templates

### Fixed
- Fix score issue with MangaUpdates
- Fixed Serbian translation
- Fix Indonesian translation
- Fix icons not filled
- Fix minor grammatical errors in Finnish strings

### Removed
- Remove inorichi's Funding.yml, and replace app-icon

## [0.16.0] - 2024-01-16

### Added
- Add back "Check for Updates" and "What's new" on about
- Add a temporary icon
- Add back update checker
- Add back analytics
- Add back reference to Discord

### Changed
- Release v0.16.0
- Update icon
- That env variable was needed
- Lint
- Change application id
- Rename master branch to main
- Rename more references
- Make version code 1
- Replace all Tachi links to Mihon
- Make tracker use Mihon's client
- Make the app Android 8+
- Replace several reference of Tachiyomi to Mihon
- Install build-tools 29.0.3
- Use newer build tools

### Fixed
- Fix update downloader borked

### Removed
- Remove unneeded env from build_push.yml
- Remove weblate from readme
- Remove unnecessary migrations

## [0.15.3] - 2024-01-13

### Changed
- Release v0.15.3
- Clean up some unnecessary bits
- Translations update from Hosted Weblate
- Better message for empty extensions list
- Update Compose compiler and Kotlin
- Minor extension repo enhancements
- Translations update from Hosted Weblate
- [download-cache] Fixed init logic to skip when cache file is missing
- Use transaction on restore to go brr.

### Fixed
- Fixed tap controls not working when zoomed in
- Fix extension interceptors receiving compressed responses
- Fixed dev UI preview

## [0.15.2] - 2024-01-08

### Added
- Add advanced setting to revoke all trusted unknown extensions
- Add filter library by customized update frequency
- Add Nord Theme

### Changed
- Release v0.15.2
- Disable some non-ready stuff for stable build
- Translations update from Hosted Weblate
- update issue templates
- Move extension repos interactors to proper package
- [track-search] Added context menu for copy and open-in-web
- Avoid floating point precision issues when converting scores
- Update dependency io.mockk:mockk to v1.13.9
- Do proper check for next chapter's download status when downloading ahead
- Trusting new extension shouldn't revoke other irrelevant extensions
- Allow permanently trusting unofficial extensions by version code + signature
- Avoid jank in extensions list if install permissions already granted
- Allow deep linking to add external repo

### Fixed
- Fix Can't scroll down to the bottom of the webtoon on the last chapter
- Fix external repo info banner in ExtensionDetailsScreen
- Fix selecting custom fetch interval not persisting sometimes

### Removed
- Remove built-in official extension repo support

## [0.15.1] - 2024-01-07

### Added
- Add link to storage FAQ in settings screen
- Add link to storage guide during onboarding step
- Support external repos
- Add ability to create manual backups with private preferences too
- Address some build warnings
- Add ability to open available extension websites in WebView
- Add basic onboarding screen
- Add extensions for handling UniFile name/file extensions
- Add unified storage location setting
- Add "Rotate wide pages to fit" for webtoon reader too
- Address more Compose lint warnings
- Add Compose lint checks
- Add separate default/apply buttons to reading mode/orientation selection dialogs
- Added library sort by mean Tracker score
- Add basic storage usage info to "Data and storage" settings screen
- Add option to flash white screen on page change in reader for e-ink displays
- Add icons for author and artist in MangaInfoHeader
- Add ability to reset chapter flags to defaults
- Add info about problematic extensions to debug logs
- Add Compose previews for reading and orientation mode dialogs
- Add haptics to SliderItem
- Add info about formatting task in CONTRIBUTING.md
- Add button to reorder categories alphabetically
- Add source preferences to backups
- Add app settings to backups
- Add project icon
- Add WebView-based user agent string to debug info
- Add more replacement suspend functions for source APIs
- Add more user-friendly network-related exception messages
- Add ResolvableSource interface for potentially opening entries directly based on some URI via a share intent
- Add documentation for HttpException
- Add cloudflare autoclose to issue_moderator.yml
- Add private extension install method
- Add support to kotlin.time APIs in the rate limit interceptor
- Address some build warnings
- Add filters to Global search
- Add function to delete downloaded chapters when migrating manga
- Address some deprecation warnings
- Add share menu item in reader
- Address minor build warnings
- Add setting and calculate for update interval
- Add debug screen to copy backup file schema
- Add tooltips for AppBarActions
- Address minor build warnings
- Add R8 rule for org.apache.commons:commons-compress
- Add slider for changing columns
- Add an icon to "Item Per Row" on library sheet
- Add interval data layer
- Add swipe actions for chapters
- Add more info to debug screen
- Add tests for MissingChapters function
- Add TODO to default to 32-bit color at some point
- Add "Rotate wide pages to fit" setting for paged reader
- Added missing chapters count in MangaInfoHeader
- Add dot beside unread chapter names
- Add explicit overflow menu options to refresh library category and manga chapters list
- Add menu shortcut to source settings in BrowseSourceScreen
- Add minLines to comfortable grid item title
- add link to FAQ in issue templates
- Add copy tags to clipboard feature
- Add option to hide entries already in library when browsing sources
- Add note to migration copy string

### Changed
- Release v0.15.1
- Translations update from Hosted Weblate
- Allow opening .tachibk files directly with app to restore
- Avoid hard crash if cached image file was already deleted
- Normalize some locale names
- Show non-localized language names too in app language selection
- Avoid showing WebView button in reader errors if page isn't actually from web
- Reword onboarding prompt for returning users
- Release v0.15.0
- Bump minimum WebView version and default user agent string
- Translations update from Hosted Weblate
- Bump dependencies
- Clean up external repos
- Disable customized fetch intervals for stable builds for now
- Revert "Implement predictive back animation "
- Change fetch interval action to show days until next expected update
- Force users to retrust unknown extensions on cold starts
- Update Mullvad DoH configuration
- Defer ACRA reporting until device is idle/not low battery/on unmetered network
- Try to show actual path in invalid location downloader notification
- Prevent creating backups with no valid options selected
- Use Material3 version of AboutLibraries
- Don't use reflection for handling backup options as boolean array
- Dedupe common LazyColumn with action at bottom layout
- Update dependency org.jsoup:jsoup to v1.17.2
- Show next expected update in interval dialog
- Misc refactoring
- Allow creating backups without library entries
- Shorten restore warning message a bit
- Allow partial restores (library/settings)
- Filter out empty source preferences when creating backups
- Clean up create backup UI
- Minor cleanup/address lint warnings
- Refactor backup option flags to normal data class of booleans
- Minor exception message cleanup
- Don't make install permission required during onboarding
- Hide private installer option for stable builds
- Implement predictive back animation
- Move backup models back to main app module
- Allow deleting downloaded chapters even if source isn't available
- Always show chapter download indicators
- Simplify storage usage bar UI implementation
- Update Coil
- Tweak page flashing
- Clean up storage usage info
- Avoid crashing if loading non-read-only private extension
- Ensure sufficiently long prefix when creating temp file
- Minor tracking cleanups
- Some domain Track model migrations
- Move backup models to domain module
- Split up BackupCreator into smaller classes
- Don't include settings as defaults when manually creating backup
- Highlight restore backup setting when navigating from onboarding step
- Don't use localized numbers for downloaded image filenames
- Whoops, accidentally made the create backup button unusable before
- Janky workaround for Moko escaped quotes issue
- Initial move of restore backup into a separate screen
- Show MIUI warning more prominently in CreateBackupScreen
- Foundations for partial restores
- Update Compose compiler
- Use smaller window to calculate fetch interval if there's less total chapters
- Prevent backing out from initial onboarding
- Bump to latest NDK LTS
- Update okhttp monorepo to v5.0.0-alpha.12
- Bump NDK
- Update ignore paths for translation PRs
- Translations update from Hosted Weblate
- Network check changes
- Fix intent used for install session
- Start downloads in IO dispatcher
- Update dependency com.squareup.okio:okio to v3.7.0
- Migrate BuildConfig to Gradle Build Files
- Target Android 14 (SDK 34) and add permission onboarding step
- Set foreground service type for ExtensionInstallService
- Target Android 12L (SDK 32)
- Set foreground service types for remaining jobs
- Split restoring logic into smaller classes
- Clean up history restoring
- Workaround for broken nav bar icon colors
- Translations update from Hosted Weblate
- Refactor onboarding steps
- Avoid crashing in SourcePreferencesFragment if source can't be loaded
- Bump dependencies
- Skip updating unchanged chapters and tracks when restoring backup
- Clean up manga restoring logic
- Proper check for when to navigate to tracker settings from tracking action
- Clean up some text alpha modifiers
- Clean up category restoring logic
- Avoid starting restore job if already running
- Onboarding screen tweaks
- Always show trackers action in MangaScreen
- Minor cleanup/docs
- Upgrade Voyager
- Translations update from Hosted Weblate
- More onboarding screen additions 2: Electric Boogaloo
- More onboarding screen additions
- Migrate to some newer date/time APIs
- Don't queue chapters on GlobalScope
- Bump dependencies
- Show average scores in tracker search results
- Minor cleanup
- Try to fall back to showing URI for storage location if concrete file path isn't available
- Migrate ReaderColorFilterView to Compose
- Force recreate download index cache on upgrade
- Clean up startDownloadNow function a bit
- Update dependency com.android.tools.build:gradle to v8.2.0
- Handle content URIs for covers
- Move workers to foreground service context a bit more safely
- Translations update from Hosted Weblate
- Revert overridePendingTransition refactorings
- Set foreground service types for library update jobs
- Invoke callback only when initiated by user
- Define storage permission in manifest
- Bump dependencies
- Replace ReaderOrientation icon resources
- Bump dependencies
- Migrate downloader service to WorkManager
- Add static key for TabNavigator
- Target SDK 30
- Ignore casing when looking for some files/folders
- Update UniFile
- Revert "Show copied to clipboard toast on Samsung devices even if Android 13+"
- Differ extra attempts to load local series' covers until chapter loading
- Adjust stats overview icons
- Show copied to clipboard toast on Samsung devices even if Android 13+
- Actually use configured storage location for local source
- Use UniFile for local source file handling
- Move automatic backups from /backup/automatic to /autobackup
- Anilist decode item description HTML
- Use unified storage location for local source
- Minor download location cleanup
- Bump dependencies
- Library update notification changes
- Avoid crashing if storage directory can't be read
- Change default PTR colors
- Call WheelPicker onSelectionChanged with initial value
- Exclude some more app state preferences from backups
- Migrate to M3 pull-to-refresh
- Fix close in action mode exists from screen
- Use unified storage location for automatic backups
- Use custom threshold for what's consider a low RAM device
- Slightly shrink continue reading button size
- Migrate XML themes to Compose
- Suppress build warnings from MPP modules
- Replace remaining Android-specific strings
- Migrate to multiplatform string resources
- Translations update from Hosted Weblate
- Migrate to standard M3 TabIndicator
- Update Scaffold fork
- Migrate deprecated progress indicator components
- Migrate deprecated tooltip components
- Bump dependencies
- Translations update from Hosted Weblate
- Use immutable collections in more places
- Update voyager to v1.0.0-rc10
- Use immutable collections in presentation-widget module
- Minor cleanup
- Update to Compose Compiler 1.5.4 and Kotlin 1.9.20
- Convert create backup dialog to a screen
- Trim scanlator of chapters in db
- Fix crash when no scanlator
- Update voyager to v1.0.0-rc09
- Update dependency org.junit.jupiter:junit-jupiter to v5.10.1
- Group mode dialogs together in bottom reader bar
- Trim `Chapter` scanlator value
- Implement scanlator filter
- Replace custom preview annotation
- Clean up reading mode / orientation enum classes
- Adjust "missing chapter count" item list styling
- Lint fixes
- Postpone Android 8 requirement
- Restrict line length with ktlint
- Minor cleanup
- Show EOL message if update check no-ops due to unsupported Android version
- No-op app update checks for Android < 8
- Revert "Require Android 8+"
- Require Android 8+
- Ensure page indicator texts are centered
- Move tracker binding logic to interactor
- Revert "Always save pages/covers in subfolders"
- Translations update from Hosted Weblate
- Bump dependencies
- New alphabetical chapter sort
- Maybe fix foreign key error during some backup restores
- Bump dependencies
- Show missing chapter count between two chapters in chapter list
- Text on tabs Overflow Ellipsis
- Combining manga information into a function
- BuildDir deprecated, use layout.buildDirectory instead
- Use same icon as chapter list items to indicate downloaded chapter in reader transitions
- Handle Brotli-compressed responses
- Don't include "app state" preferences in backups
- Record time when last automatic backup was created
- Abstract out library last updated timespan text
- Clean up chapter restoring logic a bit
- Make scrollbar slightly chonkier
- Try to ensure that reader page error message is removed if image is loaded
- Translations update from Hosted Weblate
- Replace AppUpdateService with a WorkManager job
- Rename "Backup and restore" settings screen to "Data and storage"
- Revert Compose update
- Yeet app update download progress notification on complete
- Set saved image date modified value to current time
- Merge branch 'patch'
- Handle reader app bar insets in Compose
- Avoid opening blobs as webpages
- Migrate reader low brightness overlay to Compose
- Update default user agent string
- Detached permission request from DiskUtil
- Update Voyager
- [dev QoL] Added AndroidStudio previews for [presentation.track] namespace
- Minor cleanup to ResolvableSource
- Update dependency ch.acra:acra-http to v5.11.3
- Allow extensions to open manga or chapter by URL
- Changed data-mappers to use function format
- Update Compose
- Update jsoup
- Decoupled Tracker Interface
- Refresh tracks before updating progress
- Translations update from Hosted Weblate
- Consistent labeled checkbox composable
- Make text clickable when removing item from tracker
- Bump dependencies
- Change Shikimori domain from ".me" to ".one"
- Update background job preferences once settings are restored
- Change crash log info to just have actual WebView version
- Show an error if backup file URI isn't returned to app when attempting restore
- Fix incorrect ext file deletion
- Minor cleanup
- [dev QoL] Added AndroidStudio previews for [presentation.history] namespace
- Bump dependencies
- Migrate top reader app bar to Compose
- Refactor to not use SubcomposeLayout
- Set read-only to private extension files
- Tweak Cloudflare help message in WebView screen
- Use AppBar abstraction in more places
- Minor cleanup
- Refactor reader bottom bar to presentation package
- Use relative touch positions for reader tap events
- Use Compose to animate bottom reader menu bars
- Automatically convert details.json to ComicInfo.xml for local series
- Always save pages/covers in subfolders
- Account for skipped entries when showing large updates warning
- Move backup restoring functions from BackupManager to BackupRestorer
- Exclude tracker credentials in backups
- Update dependency com.google.android.material:material to v1.10.0
- Update dependency androidx.benchmark:benchmark-macro-junit4 to v1.2.0-rc02
- Specify broadcast receiver export flags
- Translations update from Hosted Weblate
- Reduce recomposition of MangaHeader
- Update social media icons
- Bump dependencies
- Update aboutlib.version to v10.9.1
- Rename new method in ConfigurableSource to get preferences
- Update SSIV and image-decoder, except with partially revert to non-broken HEIF/AVIF support
- Update SSIV and image-decoder
- Tracker-related cleanup
- Bring back relative timestamp translations
- Translations update from Hosted Weblate
- Bring back simplified relative timestamp setting
- Bump dependencies
- Consistently use absolute date strings everywhere
- Run Netlify Build Hook after Release
- Clean up fetch interval tests a bit
- Update dependency io.github.fornewid:material-motion-compose-core to v1.0.7
- Update dependency com.google.gms:google-services to v4.4.0
- Update xml.serialization.version to v0.86.2
- Tweak reading mode and orientation sheet designs
- Update website links
- Change website URLs to reflect changes
- Translations update from Hosted Weblate
- Update to Kotlin 1.9.10
- [Download Queue] Move series to bottom
- Bump dependencies
- Change backup file names
- Update dependency io.kotest:kotest-assertions-core to v5.7.1
- Minor updates
- Use app name in biometric unlock dialog
- Update dependency io.kotest:kotest-assertions-core to v5.7.0
- Update dependency ch.acra:acra-http to v5.11.2
- Translations update from Hosted Weblate
- "Updates" widget for Galaxy Z Flip5 cover screen
- Update linting task in action workflows
- Switch to different ktlint plugin
- Bump dependencies
- Limit amount of updates loaded for widget
- Refactor some tracking-related logic
- Update kotlinx.serialization
- Refactor some tracking-related logic
- Use default non-final resource IDs behavior
- Revert Compose upgrade
- Better ignore irrelevant files when indexing downloads
- Don't run automatic backup or library update jobs if battery is low
- Bump dependencies
- Replace mentions with links to profiles in the release information
- Only set the dialog title if not already set in the extension
- Upgrade to Gradle 8.3
- Translations update from Hosted Weblate
- Minor cleanup
- Upgrade to AGP 8.1.0
- Bump dependencies
- Make source ID generation function reusable to extensions
- Set tracker finished date when manually updating to last chapter
- Update Compose
- Bump dependencies
- Clean up SetFetchIntervalTest
- Minor reader cleanup
- Make some error messages localizable
- Bump dependencies
- Consider local manga as downloaded when filtering in reader
- Always include bound trackers when migrating/copying
- Translations update from Hosted Weblate
- Fix saved state
- [Hotfix] Fix bug of not fetch update if manual library refresh as fetch period have lower limit
- Migrate bottom reader menu to Compose
- Migrate reader shortcut menus to Compose
- Drop support for extension-lib 1.3
- Combine tracking OAuth login activities
- Dismiss extension update notification if all updates installed
- More refactoring of expected next update logic
- Refactor some Screens to be classes
- Show ellipsis in longer OSS library names
- Minor cleanup
- Revert to AGP 8.0.2
- Update benchmarking dependencies
- Set useDefaultDebugSigningConfigForProfileableBuildtypes flag
- Disable profiling on preview builds
- Upgrade to SQLDelight 2
- Weblate translations
- Translations update from Hosted Weblate
- Subscribe to download queue state changes in UpdatesScreen
- Don't show future timestamps as Recently
- Avoid badly wrapped buttons in DuplicateMangaDialog
- Show feedback message when downloads index manually invalidated
- Avoid showing duplicate entry dialog for same entry
- Cleanup related to fetch interval display
- Minor cleanup
- Update Manga in Expected Period
- Show help banner when Cloudflare captcha page is shown in WebView
- Better handle saving animated drawables
- Don't attempt to show non-bitmap image in notification when saving
- Allow more flexible custom preference composables
- Bump dependencies
- Minor cleanup
- Refactor duplicate chapter number formatters
- Update richtext to v0.17.0
- Update dependency org.junit.jupiter:junit-jupiter to v5.10.0
- Refactor backup and restore to support cross device sync.
- Use previously updated track item when binding start date
- Clean up preference extensions/items a bit
- Avoid triggering new search for same query in global search
- Bump dependencies
- Don't require deeplink ext target to be pinned
- Bump dependencies
- Use correct sources when triggering new global search
- Increase max lines for title in global search to 3
- Trigger new search on source filter change
- Dedupe SearchScreenModels
- Minor refactoring
- Replicate global search filters to migrate screen
- Dedupe Global/MigrateSearchContent composables
- Use consistent extension icon URLs
- Set start date when tracker is bound if any chapters are already read
- Constrain reader sheet to max 75% of height
- Replace reader sheet dropdowns with chips
- Use Material3 chips
- Don't update chapter progress if current page is errored
- Update dependency gradle to v8.2.1
- Finish up reader reading mode settings compose migration
- Replace library sheet display modes with FlowRow of Chips
- Replace some reader sheet settings with FlowRow of Chips
- Clean up NetworkHelper
- Use segmented buttons for reader background setting in sheet
- Implement showing selected per-series reader settings
- Move all pager/webtoon reader setting to Compose sheet
- Tweak global search source filtering
- Mark some state data classes as immutable
- Handle Cloudflare in default network client and deprecate cloudflareClient
- Translations update from Hosted Weblate
- Prevent keyboard when using SelectItem in filters
- Use system APIs to localize percentage numbers
- Move boolean reading mode prefs to Compose sheet
- Change the wording to "Retry" when page fails to load.
- Actually retry when a page fails to load in Browse screen
- Initial migration of general reader settings to Compose
- Move SettingsItems composables to presentation-core
- Refactor chapter tracking logic
- Set proper defaults for new table columns
- Database changes to support library syncing
- Update aboutlib.version to v10.8.2
- Bump dependencies
- Handle chapter read status in correct order
- Update aboutlib.version to v10.8.1
- Refactor reader progress/history logic
- Minor reorganization
- Allow download ahead even if entry isn't favorited
- Group Compose compiler and Kotlin version upgrades
- Tweak chapter swipe directions and icon color
- Translations update from Hosted Weblate
- Upgrade Okio
- Replace swipe action method
- Adjust manga FAB to only say "Start" if there's no unread chapters in unfiltered list
- Change auto clear cache to occur on app launch instead
- Update xml.serialization.version to v0.86.1
- Save reader progress on every page change
- Configure external-files-path for files provider
- Upgrade to Kotlin 1.8.22
- Translations update from Hosted Weblate
- Replace deprecated ProgressDialog
- Accept third party cookies in WebView instances
- Bump dependencies
- Browse Source: clear search query when changing listing
- Show a progress indicator while checking for updates in the about screen
- Show open source library license in a custom screen
- Migrate deprecated swipeable
- Make source preferences' titles multiline
- Use same icons as action bar in swipe actions
- Retry LibraryUpdateJob later if Wi-Fi condition not met
- Retry DelayedTrackingUpdateJob up to 3 times if all items not updated
- Update aboutlib.version to v10.8.0
- Don't affect reader toolbars/sheets when using custom brightness
- Migrate ReaderColorFilterSettings to Compose
- Refactor grid size slider composable for reuse
- Use our own translation for "OK"
- Trackers empty scores start starts from middle
- Migrate ReaderPageSheet to Compose
- Minor cleanup
- Bump default user agent string
- Better handle decimal chapter numbers and add categories in ComicInfo.xml files
- Composed Modifier changes
- Use lite compose-ui-tooling module on release builds
- Update Guava
- Update core-splashscreen
- Update Compose BOM v2023.06.00-alpha01
- Update Paging and match version
- Bump compile SDK version 34
- Update dependency ch.acra:acra-http to v5.10.1
- Update dependency io.github.fornewid:material-motion-compose-core to v1.0.3
- Translations update from Hosted Weblate
- Avoid crash when trying to open random entry but categories are still loading
- Blur manga info header image
- Don't update last page read/read state of chapter if Incognito Mode is enabled
- Don't update trackers after reading a chapter if Incognito Mode is enabled
- Increase update screen limit to 500
- Filter out non-downloaded chapters in reader when Downloaded Only is enabled
- Increase swipe action touch slop
- Cleanup MangaScreenModel successState usage
- Directly track current WebView URL instead of relying on state
- Bump dependencies
- Convert to Compose
- Translations update from Hosted Weblate
- Hide release period update restriction in non-dev builds until ready
- Bump dependencies
- Replace RxJava in extension installer
- Limit updates to 250 most recent chapters
- Minor cleanup
- Update Glance v1.0.0-beta01
- Set reader chapter name to marquee if too long
- Slightly tweak MangaScreen refresh indicator
- Use primitive state holders
- Bump Compose BOM version 2023.04.00-beta01.1
- Simplify chapter item composable a bit
- Minor cleanup and remove unused dependencies
- Replace RxJava in Downloader
- Bump dependencies
- Update minimum WebView version
- Update default user agent string
- Update dependency com.github.requery:sqlite-android to v3.42.0
- Upgrade Compose
- Replace Cascade with our own somewhat janky implementation
- Use AppBarActions in more places
- Update dependency com.github.requery:sqlite-android to v3.41.2
- Update leakcanary to v2.11
- Translations update from Hosted Weblate
- Enable predictive back gesture for Android 13 (behind developer option)/14+
- Populate the ComicInfo Number field with chapter numbers
- Fix freezing on initial loading of cache file
- Minor Downloader cleanup
- Bump xmlutil
- Avoid attempts to renaming download dirs if name hasn't actually changed
- Translations update from Hosted Weblate
- Revert "Bump to somewhat newer version of Compose BOM"
- Replace our custom Pager
- Upgrade Kotlin 1.8.21
- Use AppBarActions in more places
- Bump to somewhat newer version of Compose BOM
- Delay automatic backup when restoring
- Switch back to upstream version of Voyager
- Bump dependencies
- Update dependency org.jetbrains.kotlinx:kotlinx-coroutines-bom to v1.7.0
- Fix rounding error when changing page with slider
- Don't compute key for browse list based on manga ID, which may be repeated
- Revert attempts to read archives to cache first
- Chapter transition tweaks
- Update dependency io.github.fornewid:material-motion-compose-core to v0.12.2
- Update dependency com.google.android.material:material to v1.9.0
- Allow scrolling in restore confirmation dialog
- Always show buttons and fix steps visual
- Translations update from Hosted Weblate
- Update dependency org.jsoup:jsoup to v1.16.1
- Ensure final download status is always set
- Fix haptic feedback
- Fix background color
- Migrate reader slider and next/prev buttons to Compose
- Migrate PageIndicatorTextView to Compose
- Get current track services when composing LibrarySettingsDialog
- Bump AGP for Android Studio Flamingo 2022.2.1 Patch 1
- Bump dependencies
- Try Apache implementation of ZipFile instead
- Update dependency io.github.fornewid:material-motion-compose-core to v0.12.1
- Move GitHub Release/App Update logic to data
- Update dependency org.junit.jupiter:junit-jupiter to v5.9.3
- Downgrade back down to Kotlin 1.8.10
- Process chapter duplicates after sorting
- Avoid potential crash when opening library settings sheet 2.0
- Extension-lib 1.5: Add AppInfo#getSupportedImageMimeTypes()
- Revert "Avoid potential crash when opening library settings sheet "
- Avoid potential crash when opening library settings sheet
- Consolidate exception message formatting
- Minor cleanup
- Reword chapter swipe action preference labels
- Handle archives with nested directories properly
- Double tap zoom toggle
- Load ZIP file contents to cache
- Maybe fix Firebase crashes
- Make loader implementation classes internal
- Minor cleanup
- Update dependency io.github.fornewid:material-motion-compose-core to v0.11.3
- Hide beta split tall images setting from reader setting sheet for release builds
- Use Compose for reader transition chapter info
- Update dependency gradle to v8.1.1
- Consolidate missing chapters functions to domain module and add tests
- Minor JavaDoc updates
- Fallback chapter name if it ends up as blank
- Bump dependencies
- Bump dependencies
- Upgrade to AGP 8.0.0
- Merge branch 'patch'
- Update dependency gradle to v8.1
- Update dependency com.google.firebase:firebase-analytics-ktx to v21.2.2
- Move library columns settings to library sheet
- Rename reading modes
- Use Kotest matchers in other test classes
- Move worker info screen into debug info menu
- Translations update from Hosted Weblate
- Add manual input
- Update dependency io.github.fornewid:material-motion-compose-core to v0.11.2
- Add haptic feedback
- Update track domain shikimori.me
- Update aboutlib_version to v10.6.2
- Skip result screen when using search intent
- Better handle overflowing content in MigrateDialog actions
- Save current chapter progress when navigating to adjacent chapters
- Check initial search query to open keyboard by default
- Bump dependencies
- Update dependency com.android.tools:desugar_jdk_libs to v2.0.3
- Update issue-moderator-action
- Make center zoom start vertically centered too
- Translations update from Hosted Weblate
- Sample updates to scrollbars
- Adjust SearchToolbar soft keyboard behavior
- Ensure EmptyScreen is scrollable
- Wrap inside Dialog
- Make pin source icon lighter
- Use IO dispatcher for some screen model work
- Don't unnecessarily wrap IOExceptions in UncaughtExceptionInterceptor
- Refactor away some unnecessary lambda expressions
- Don't attempt to initialize manga details from BrowseSource or Search screens
- Restore POST_NOTIFICATIONS permission check for SDK 33+
- Skip POST_NOTIFICATIONS permission check for now
- Subscribe to changes to manga in BrowseSourceScreen
- Cleanup Preference.asHotFlow()
- Simplify code in missing chapters warning
- Adjust missing chapters UI
- Bump dependencies
- Bump Compose dependencies
- Bump dependencies
- Rename Complications -> Overlay
- Bump subsampling-scale-image-view
- Revert "Always attempt to split tall images when downloading"
- Move isLocal extension functions to LocalSource
- Misc cleanup
- Split up ContextExtensions into smaller files
- Clean up WorkManager usages a bit
- Convert BackupRestoreService to a WorkManager job
- Show proper string in manga detail screen for SourceNotInstalledException
- Set default automatic library updates to off
- Simplify some of the notification builders
- Migrate things to use newer data models
- Update dependency com.github.requery:sqlite-android to v3.41.1
- Re-enable ComicInfo.xml generation on download
- Always attempt to split tall images when downloading
- Clean up library display settings tab a bit
- Translations update from Hosted Weblate
- Do networkToLocal and initializeManga inside flow
- Adjust tab indicator visual
- Initialize download index disk cache
- Bump dependencies
- Refactor tracker status string mappings
- Update CI badge in README
- Revert "Fix banners-related issues"
- Bump dependencies
- Bump compose-bom version 2023.02.00-rc02
- Move more things to domain/data modules
- Use stricter visibility for composables where possible
- Translations update from Hosted Weblate
- Use Compose icons instead of drawables
- Refactor SourceManager/StubSource to domain module
- Move some preferences into domain module
- Move sourceMapper to data module
- Show proper message when doing global update
- Bump default user agent string and minimum WebView version
- Convert source modules to Kotlin Multiplatform
- Inline DownloadQueue into Downloader
- Use queued last chapter read number when performing delayed tracker update
- Minor refactoring
- Move Local Source to separate module
- Move all DownloadService.stop calls to Downloader
- Avoid crashing in SourcePreferencesScreen if source can't be loaded
- Avoid crash in DeleteLibraryMangaDialog
- Close source filter dialog when filtering
- Avoid uncaught exceptions from OkHttp interceptors crashing entire app
- Translations update from Hosted Weblate
- Misc Downloader state cleanup
- Simplify filter logic
- Make DownloadManager the sole entry point for DownloadService
- Migrate TriState usages to TriStateFilter enum
- Bump dependencies
- Use M3 date picker
- Migrate source filter sheet to Compose
- Bump compose-bom version 2023.02.00-beta02
- Bump dependencies
- Convert downloadChapter to suspend function
- Consolidate all theme colors to presentation-core module
- Move CheckboxState to core module
- Use Compose Foundation's flow layout
- Use non-stable Compose BOM
- Move more components to presentation-core module
- Avoid crash when loading invalid extension package
- Merge branch 'patch'
- Avoid crashes if headers can't be built for usage in WebView
- Use unique keys for all screens to avoid crashes
- Migrate library settings sheet to Compose
- Update dependency gradle to v8.0.1
- Minor settings sheet cleanup
- Move more components
- Move more components to presentation-core module
- Move more components to presentation-core module
- Start moving some Compose components to presentation-core module
- Move chapter utils to domain module
- Move more things to domain module
- Bump dependencies
- Only show unread entries in widget
- Translations update from Hosted Weblate
- Avoid crashing if getChapterUrl is not implemented
- Avoid navigator-related crash when handling onNewIntent
- Avoid crashing if opening browse with unavailable source
- Simplify PageHolder load Job
- Don't apply Wi-Fi network restriction for manual library update jobs
- Rework on the wheel picker
- Open global search when Browse is tapped twice
- Replace Local and In Library badge text with icons
- Move reader preloading to IO scope
- Avoid preload download check if chapter is already loaded or loading
- Clean up LibraryItem
- Replace custom download amount with next 25
- Update Cascade
- Disable memory cache
- Bump dependencies
- Clean up chapter item composables a bit
- Rename Security settings to Security and privacy
- Prioritize finding selected chapter when deduping reader chapters
- Fix snackbar bottom inset
- Update version check for library update job migration
- Fully utilize WorkManager for library updates
- Replace RxJava in DownloadQueue
- Tweak Response.parseAs() to utilize intrinsics

### Fixed
- Fix RAR loading
- Fix lint error
- Fix temp chapter files not being able to be created when reading
- Fix next expected update being weird number sometimes
- Fix extension settings icon trying to install update instead of opening details
- Fix read duration statistic getting inflated when restoring history
- Fix download indexing with changed storage locations
- Fix settings screen crashing when saving state
- Fix next local chapter not being indicated as downloaded in transition
- Fix sharing saved pages from notification
- Fix PTR initial refreshing state
- Fix PTR extra offset calculation
- Fix searchbar style
- Fix Catalan plurals manually
- Fix EmptyScreen kaomoji looking broken for RTL locales
- Fix README.md typo
- Fix checkboxes not working after scrolling in filter sheet
- Fix duplicate files being created when saving pages on Android 10+ with separate folders setting enabled
- Fix hide entries in library setting causing browse to not load
- Fix track search item not filling width if content is too short
- Fix cut off labels in reader sheet toggles
- Fix missing inversion in tap zones help overlay.
- Fix migration flags usage (incorrect defaults and copy mode)
- Fix unit tests
- Fix fresh database installs
- Fix window undimming when reader custom filter settings are open
- Fix to multiple chapter download incorrect state
- Fix swipe action preference labels
- Fix download ahead
- Fix up icon direction when RTL
- Fix crash when tapping reader in long strip mode before RecyclerView is created
- Fixed scrolling on the background using long strip
- Fix download ahead while reading functionality
- Fix LibraryFlagsTest
- Fix misleading release grace period "Default" options
- Fix bookmarked chapters being deleted after manually marked as read
- Fix some crashes
- Grid size slider
- Fix navigation backstack
- Fix missing appbar when statistics are loading
- Fix StubSource param order to match previous SourceData order
- Fix unit tests not running in workflows
- Fix filter FAB not working in migrate screen
- Fix delay between URL fetch and image download
- Fix language in source filter list jumping to top incorrectly
- Fix to multiple "add to library" toasts bug when adding a new series
- Fix manga chapter flags not working
- Fix exception formatter's format
- Fix disable source option not appearing
- Fix misused string key in library context menu
- Fix missing type info in release builds
- Fix missing type info in release builds
- Skip duplicate chapters on download ahead if option to skip duplicates is enabled
- Fix automatic backups not working
- Fix Spanish (Latin America) being missing from in-app language selection
- Fix banners-related issues
- Fix per-category sort/display affecting the wrong category
- Fix download queue page count display bug
- Fix package names
- Fix occasional crash when opening library settings sheet
- Fix height shift when scrolling through themes
- Fix ID type mismatch in MigrateSearchScreenModel
- Fix crash in library when selected category is deleted

### Removed
- Remove custom extension readme/changelog URLs
- Remove tmp chapter files after exiting reader
- Remove skipped updates notification
- Remove redundant job setup calls in migrations
- Remove action to delete saved image in notification
- Remove storage permission check when manually creating backups
- Remove unused resources
- Remove storage permissions
- Remove max automatic backups setting
- Remove animateItemPlacement modifier usage
- Remove remaining usages of platform-provided strings
- Remove duplicated logic for binding enhanced trackers
- Remove beta webtoon viewer split page
- Remove old FastScroller
- Remove unused rxandroid dependency
- Remove unnecessary profileable flag in manifest
- Remove need for SQLDelight primitive adapters
- Remove relative timestamps setting
- Remove some uses of color resources
- Remove fast scrollbar from some unnecessary places
- Remove legacy settings sheet
- Remove bad translations
- Remove unused tabbed sheet layouts/classes
- Remove scrollable animation workaround
- Remove some dead code
- Remove usage of savedInstanceState for storing reader menu visibility state
- Remove manga from trackers
- Remove General settings section
- Remove per-category display mode
- Remove confirm exit option
- Remove redundant inset handling in AdaptiveSheet
- Remove SourceData and use StubSource directly for database
- Remove "when tapping" from "Pan wide images" setting
- Remove abstract TabeedBottomSheetDialog class
- Remove horizontal padding of actions row in empty screen
- Remove crash log notification in favor of sharing directly
- Remove unnecessary withIOContext
- Remove download all chapters menu item
- Remove some app translations that have low completion rates
- Remove redundant Downloader isNotification argument
- Remove some unused resources
- Remove dependency injection from core module and data module from presentation-widget module
- Remove unnecessary usages of NotificationManagerCompat to actually create notifications
- Remove unused Rx/Coroutines converters
- Remove RxJava in PageHolder
- Remove background extensions updates check
- Remove background app update check
- Remove FAB extra padding in DownloadQueueScreen

## [0.14.7] - 2023-10-25

### Changed
- Release v0.14.7
- Update website links
- Update default user agent string
- Avoid opening blobs as webpages
- Change Shikimori domain from ".me" to ".one"
- Run Netlify Build Hook after Release
- Use consistent extension icon URLs

## [0.14.6] - 2023-04-16

### Changed
- Release v0.14.6
- Avoid uncaught exceptions from OkHttp interceptors crashing entire app
- Update track domain shikimori.me
- Better handle overflowing content in MigrateDialog actions
- Save current chapter progress when navigating to adjacent chapters
- Bump subsampling-scale-image-view
- Show proper string in manga detail screen for SourceNotInstalledException
- Set default automatic library updates to off
- Use queued last chapter read number when performing delayed tracker update
- Bump default user agent string and minimum WebView version
- Avoid crashing in SourcePreferencesScreen if source can't be loaded
- Avoid crash in DeleteLibraryMangaDialog
- Avoid crash when loading invalid extension package

### Fixed
- Fix Spanish (Latin America) being missing from in-app language selection
- Fix download queue page count display bug
- Fix occasional crash when opening library settings sheet

## [0.14.5] - 2023-02-19

### Changed
- Release v0.14.5
- Avoid crashes if headers can't be built for usage in WebView
- Avoid crashing if getChapterUrl is not implemented
- Avoid navigator-related crash when handling onNewIntent
- Avoid crashing if opening browse with unavailable source
- Move reader preloading to IO scope
- Avoid preload download check if chapter is already loaded or loading
- Disable memory cache
- Prioritize finding selected chapter when deduping reader chapters
- Fix snackbar bottom inset

### Fixed
- Fix ID type mismatch in MigrateSearchScreenModel
- Fix crash in library when selected category is deleted

### Removed
- Remove FAB extra padding in DownloadQueueScreen

## [0.14.4] - 2023-02-05

### Added
- Add Reader Setting to Skip Dupe Chapters
- Add Suwayomi tracker

### Changed
- Release v0.14.4
- Don't show SourceNotInstalledException name in error snackbar
- Revert "Show no pinned sources message when attempting to migrate/search"
- Bump desugaring libs
- Translations update from Hosted Weblate
- Update dependency com.android.tools.build:gradle to v7.4.1
- Call.await(): copy exception message when preserving error stack
- Show exception class in snackbar message
- Misc Service cleanup
- Update dependency androidx.compose.material:material to v1.4.0-alpha05
- Update dependency com.google.android.material:material to v1.8.0
- Update dependency androidx.core:core-ktx to v1.10.0-alpha02
- Set InsertPage status to Ready
- Move some interactors to domain module
- Move more things around
- Split UpdatesGridGlanceWidget into smaller bits
- Move Glance Widget to seperate module
- [BackupRestorer] Handle uncompressed backups
- Don't crash on timeout in renewCache()
- OkHttp Call: split await() and awaitSuccess()
- Replace PageLoader.getPage() with PageLoader.loadPage()
- Move more to data and domain modules
- Move more implementation to data module
- Move more models to domain module
- Move more repositories to domain module
- Move more models to domain module
- Move more models to domain module
- Move Category `model` and `repository` to domain and data layer
- Update sqldelight to v1.5.5
- Update dependency io.github.fornewid:material-motion-compose-core to v0.10.4
- Update dependency com.google.gms:google-services to v4.3.15
- Save current page state on configuration change
- Make download function follow reader preference
- Replace RxJava in HttpPageLoader downloader
- Translations update from Hosted Weblate
- Move SQLDelight to data module
- Move shared configuration to subprojects in root Gradle file
- Don't use platform attributes for white/black reader backgrounds
- Create plugin for linting
- Upgrade to Kotlin 1.8.0
- Update local source icon and differentiate from fallback source icon
- Hide WebView menu item in reader if local
- [MyAnimeList] Handle cases where my_list_status.status is not present
- Revert "Update dependency androidx.compose.material:material to v1.4.0-alpha04 "
- Update dependency androidx.compose.material:material to v1.4.0-alpha04
- Assign keys for global search rows based on source
- Convert PageLoader.getPages to suspending function
- Prevent scrolling outside bounds in webtoon/vertical reading mode
- Bump versionCode to prevent downgrades
- Allow partially read chapters to be marked as unread in updates screen
- Enable `confirmButton` only when needed to respond to user input
- Replace RxJava in ChapterLoader and ReaderViewModel
- Make androidx.preference dialog match M3 dialog
- Show chapter scanlator on reader transition
- Show loading indicator during migration
- Suwayomi Tracker: sync changes with Tachidesk v0.6.6
- Only how indexing downloads banner the first time
- Disable Gradle configuration cache
- Parallelize global search properly
- Minor cleanup
- Bump to latest Compose stable BOM
- Bump AGP
- Tweak `TriStateItem` view to match in earlier app version
- Show proper Exception message in MangaScreen
- Don't prompt to add to library multiple times
- Reword set category dialog confirmation to "OK"
- Update library sheet filter tab on open
- Bump core-ktx dependency
- Minor dependency updates
- Refactor how extensions list is modelled
- Show no pinned sources message when attempting to migrate/search
- Show the tracker name when showing error toast
- Replace RxJava in DownloadQueueScreenModel
- Avoid crash if multiple instances of ClearDatabaseScreen opened
- Don't exclude same source when checking for duplicate entries
- Use Voyager for WebView in non-reader places
- Make MIUI extensions warning clearer that it's only a suggestion
- Use theme padding values in more places
- Avoid crashes when fetching assist content URL in ReaderActivity
- Only show MIUI extension warning on MIUI >= 13
- Make global search results more compact
- Only show library continue reading button if there's unread chapters
- Show available but not installed enhanced trackers
- Bump minimum ext-lib to 1.3
- Avoid crashes when opening WebView from reader
- Update dependency com.squareup.okio:okio to v3.3.0
- Bump dependencies
- Adjust bookmarked chapter styling in Updates

### Fixed
- Fixup HttpPageLoader _loadPage
- Fix extension search query cursor and debounce
- Fix installing extensions on MIUI
- Fix checking downloads banner showing up incorrectly
- Fix DownloadPageLoader resource leak
- Fix ChapterCache.isImageInCache() resource leak
- Fix downloaded filter unmatched state in manga screen
- Fix double tapping History not working consistently
- Fix crash in categories screen on config change
- Fix reader settings sheet's mode section not updated
- Fix floating-point error in navigate pan
- Fix reader settings sheet not updated

### Removed
- Remove repetition in enhanced tracker preference declarations
- Remove ability to hide unread chapter badges in library

## [0.14.3] - 2023-01-07

### Added
- Add worker info screen
- Add Assistant content URLs
- Add back option to hide Updates count
- Add "jitpack" maven repo to pluginMangment
- Add reindex downloads description
- Add back track icon onClick and title onLongClick actions
- Add shecan DoH provider
- Add Kavita tracker
- Add option to invalidate download cache
- Add "Play" button on manga in library
- Add back haptic feedback long tap to fav
- Add pseudolocales to dev builds

### Changed
- Release v0.14.3
- Update baseline profile
- Translations update from Hosted Weblate
- Bump default user agent string and minimum WebView version
- Open entry when long pressing during migration in source search
- Use MainScope for coroutines in ui package classes
- Adjust bookmarked chapter styling
- Prioritize "all" ("Multi") lang in extensions lists
- Show warning about installing extensions on MIUI
- Handle file names with multiple ".cbz" occurrences properly
- Update toolbar query on genre search
- Debounce reindexing banner
- Unify layout for new update and crash screens
- Allow 2 lines for tracker status text
- Handle 1000+ pages properly in the downloader
- Handle 1000+ pages properly in the downloader
- Filter mangaupdates search
- Update OkHttp
- Increase max library column size back to 10
- Properly fix #8720
- Fix pop behavior after confirming removal
- Update baseline profile
- Update plugin kotlinter to v3.13.0
- Bring back previous snapping behavior
- Update WorkManager
- Pass listing query to BrowseSourceScreen
- Translations update from Hosted Weblate
- Clean up usages of listing UI models
- Don't blindly consume back event
- Move library page EmptyScreens into list/grids
- Minor cleanup
- Track Page progress with StateFlow
- App state banner tweaks
- Use actual indexes instead of existing order number when reordering categories
- Sort global search source results properly
- Don't start at last read page if chapter is completely marked as read
- Better handle status bar light/dark icons based on banner background color
- Check ext lib version when checking for updates
- Convert download cache/queue flows into SharedFlows
- Update richtext to v0.16.0
- Adjust insets handling in tablet UI
- Move system bar color set to the main composable
- Pull out settings sheet items as reusable composables
- Adjust screen transitions
- Move app state banner to the very top
- Abstract ChapterSettingsDialog for reuse elsewhere
- Reuse basic theme preview annotation
- Show empty screen when a category is empty
- Use proper category when getting random item
- Disable Jetifier
- Replace reader's Presenter with ViewModel
- Bump dependencies
- Migrate Accompanist SwipeRefresh to Compose PullRefresh
- Cleanup Page status
- Add unique key
- Avoid some crashes
- Avoid crashing when clearing cookies for invalid source URLs
- Handle intent after navigator is initialized
- Minor cleanup
- Always show library tabs and counts when searching
- Change source preference theming fix
- Hide webtoon reader scrollbars
- Truncate long nav bar/rail items
- Tweak manga cover dialog UI
- Track sheet fixes
- More domain model migrations
- Migrate Download to domain model
- Update dessant/lock-threads action to v4
- Translations update from Hosted Weblate
- Change Updates icon badge to show new updates count
- Ignore WheelPickerCompose updates
- Replace RxJava in ReaderChapter and reader transitions
- Replace some usages of RxJava in reader
- Merge Voyager screens
- Use Voyager on Source Preference screen
- Migrate to Accompanist M3 theme adapter
- Delayed Tracking Update related fix
- Use Voyager on BrowseSource and SourceSearch screen
- Use Voyager on Downloads screen
- Complete Settings migration to Voyager
- Don't remove queued downloads when deleting manga after chapter deletion
- Minor cleanup
- Update dependency ch.acra:acra-http to v5.9.7
- Minor global search UI tweaks
- Show toolbarTitle depending of size
- Use Compose on Global/Migrate Search screen
- Show empty library message properly
- Update aboutlib_version to v10.5.2
- Update dependency gradle to v7.6
- Implement simple stats screen
- Use Voyager on Library tab
- Translations update from Hosted Weblate
- Use Voyager between more screens
- Use Voyager between supported screens in Extension package
- Disable generating ComicInfo.xml on download
- Explicitly add READ_APP_SPECIFIC_LOCALES permission
- Use Voyager on Migrate Manga screen
- Use Voyager on Browse tab
- Cleanup [Downloader.ensureSuccessfulDownload]
- Use Voyager on Updates tab
- Change settings screen to object
- Avoid concurrency issues when reordering categories
- Delete empty source folder when deleting all downloads for a manga
- Implement copying of Manga URL to Clipboard
- Allow zooming in WebView
- Don't attempt to check chapter download status for local chapters
- Use Voyager on Extension Details screen
- Update dependency com.github.requery:sqlite-android to v3.39.2
- Use current timezone when setting tracker dates
- Translations update from Hosted Weblate
- Limit parallelism for Coil image loading
- Bump dependencies
- Tweak library selection
- Bump image-decoder dependency
- Show toast when no next chapter found in library
- Don't rely on cache when deleting empty manga folders
- Retain previous selected state when updating list states
- Minor cleanup
- Make padding names neutral
- Clean up ComicInfo stuff a bit more
- Change long press on downloaded chapter icon to open menu
- Adjust download cache to ignore irrelevant files
- Better physical keyboard support
- Bump test dependencies
- Update leakcanary to v2.10
- Update actions/dependency-review-action action to v3
- Translations update from Hosted Weblate
- Resolve proper chapter URL for ComicInfo "Web" field
- Use Voyager on Source Filter screen
- Use Voyager on Extension Filter screen
- Clean up ComicInfo stuff a bit
- Create ComicInfo Metadata files on chapter download
- Reword more references to "manga" in strings
- Replace numberpicker with wheelpicker
- Temporally Fix #8287
- Reword download cache/indexing strings for consistency
- Migrate to more domain model usages
- Minor cleanup
- Tweak library continue reading button
- Voyager on More tab
- Update dependency androidx.compose:compose-bom to v2022.11.00
- Bump dependencies
- Use toShareIntent in WebViewActivity
- Full Compose MangaController
- Don't use default Lenovo "browser" handler
- Update dependency com.bluelinelabs:conductor to v3.1.8
- Voyager on History tab
- Use Voyager on Category screen
- Update dependency com.github.junrar:junrar to v7.5.4
- Don't show copied to clipboard toast on A13+ when copying backup restore error
- Get index of selected update list item based on chapterId
- Adjust read next history logic
- Retry the MAL request if the token is expired
- Toggle enabled source in bulk
- Bump default user agent string
- Increase visibility of selected item background in dark themes
- Enabled isPseudoLocalesEnabled for debug
- Revert "Tweak how `getChapterUrl` works "
- Ignore gradle.properties.swp
- Center extension name in `ExtensionDetailsScreen`

### Fixed
- Fix downloaded badges appearing when filtering by downloaded
- Fix browse search query display and keyboard focus
- Fix navigate up and filter sheet
- Fix snackbar blocking refreshing state in MangaScreen
- Fix indexing notif not showing
- Fix crash if tapping title when opening reader directly
- Fix SetMangaViewerFlags
- Fix appbar back button in global search screen
- Fix opening download notification only going to More tab
- Fix migrate options dialog not being selected when tapping text
- Fix ANR when opening from notification/widget
- Fix local source detail JSON files not being read if .noxml was created
- Fix unusable categories when content is filtered out
- Fix appbar back button in Settings screen
- Fix BrowseSourceScreen list/grid unnecessary reloads
- Fix crash when opening chapter from BrowseSourceScreen
- Fix default category name being shown with empty library
- Fix refreshing state for extensions tab
- Fix Stub Source migration screen broken
- Fix library not loading when not logged in to any tracker
- Fix Kavita interceptor crashing app + minor cleanup
- Fix invert tapping dropdown not updating checked state in reader
- Fix url sharing
- Fix related to cancelling queued chapters
- Fix monochrome launcher icon not applied when non-round shape is used
- Fix download not working on sd card
- Fix clearing database freezes the app

### Removed
- Remove unused resources
- Remove some dead code
- Remove unnecessary base Nucleus classes
- Remove dead code
- Remove usage of PublishRelay in DownloadQueue
- Remove unused resources
- Remove duplicate pinned sources setting
- Remove "Download complete" notification
- Remove top bar workaround
- Remove redundant compiler args

## [0.14.2] - 2022-10-31

### Added
- Add different download options within the Library
- Add warning about F-Droid build support in More screen
- Add ability to open random manga
- Add more context to obsolete extension warning

### Changed
- Release v0.14.2
- Avoid crashing if multiple entries exist for same URL/source
- Translations update from Hosted Weblate
- Perform haptic feedback where appropriate
- Use `selectedBackground` for other list items to match with others
- Set `softWrap` to true again for `Pill` text
- Tweak how `getChapterUrl` works
- Reword "title"/"titles -> "entry"/"entries"
- Disable `ChapterHeader` & `ChapterDownloadIndicator` click when in selection mode
- Clean up library download chapters logic
- Use proper content color for filter icon in library toolbar
- Use BOM for kotlinx.coroutines dependencies
- Set source properly when creating manga entries
- Clean up download ahead logic
- Downgrade to org.jetbrains.kotlinx:kotlinx-serialization-json 1.4.0
- Refactor search toolbar and fix browse source
- Use Compose fast* functions in more places
- Don't explicitly set text color in the text
- Refactor overflow menus into a composable
- Center global search prompt properly in library list mode
- Rebase Scaffold fork
- Add navbar padding
- Update voyager to v1.0.0-rc06
- Restore chapter description alpha
- Apply bottom content padding to large screen info column
- Few UI changes
- Use remember var delegates in more places
- New Pager implementation

### Fixed
- Fix resetting filter resets browse pager
- Fix crash in ReaderReadingModeSettings when reverse portrait orientation is set
- Fix some crashes
- Fix Layout Inspector's Compose tree for dev flavor
- Fix share menu item not appearing for entries not in library

### Removed
- Remove redundant preference composables

## [0.14.1] - 2022-10-29

### Changed
- Release v0.14.1
- Translations update from Hosted Weblate
- Clean up strings and icons
- Show notification while download cache is renewing
- Make Compose DropdownMenu overlap the trigger
- Sort library items alphabetically in secondary pass
- Prompt Extension update if ext-lib is updated
- Add subtitle provider to ListPreference
- Add param to generate Compose compiler metrics
- Reorder parameters of JSON parsing method
- Update dependency androidx.paging:paging-compose to v1.0.0-alpha17
- Update voyager to v1.0.0-rc05
- Avoid concurrency crashes in SourceManager
- Consider downloaded only mode when getting download counts in library
- Reword "manga" to more generic "entry"/"entries"
- Don't filter out partially read chapters when marking as unread
- Use MaterialTheme.shapes in more places
- Touch up manga grid/list items
- Cleanup Library presenter
- WebView for chapter link

### Fixed
- Fix some crashes
- Fix library download counts not being loaded if downloaded filter is in exclusion state
- Fix "Download split" not working while using SD card

## [0.14.0] - 2022-10-28

### Added
- Add Crash activity
- Add bookmark filter
- Add padding to track search dialog error message
- Add JavaScriptEngine abstraction to extensions-lib
- Add methods to get manga and chapter url
- Add `GET(HttpUrl)` overload
- Add a proguard rule for XMLUtil
- Add support to update strategy on global update
- Add some padding to tab indicators
- Address some OkHttp nullability changes
- Add "Njalla" dns provider
- Add last update time to Updates Tab
- Add APK output for x86_64 CPU architecture
- Add DelicateCoroutinesApi to GlobalScope extension functions
- Add Mullvad and Control D as DoH providers
- Added tickers in the reader page slider
- Add ref to push workflow concurrency group
- Add task to generate locales_config.xml
- Add back reset action to the Library and History Search toolbars
- Address misc. build warnings
- Add missing `Authorization` header on MAL refresh token request
- Add scroll overlay to LibraryToolbar
- Add fast scroller to Library screen
- Add downloaded icon in TransitionView when chapter is downloaded
- Add Stable interface for Category state
- Add MIME type mapping for image/jxl
- Add new "Lavender" theme
- Add string for future app language toggle preference
- Add Composable preview for preferences
- Add fast scroller to extensions screen
- Add Cancel button to App Update Notification
- Add `date_upload` to `toDbChapter()`
- Add more DoH providers
- Add read last read chapter shortcut
- Add MangaUpdates as a tracker
- Add scrollbar indicator to LazyColumn
- Add ability to show manga when clicking item in migration search process
- Add missing top padding for screen that was rewritten in Compose
- Add long click action on chapter download button
- Add switch to DownloadPageLoader when chapter is downloaded
- Add option to reset viewer flags
- Address some build warnings
- Add option to automatically split tall downloaded images
- Add `-r` flag to ShizukuInstaller `createCommand`
- Add newer methods to StubSource
- Add links to website FAQ for library update and download warning notifications
- Add error state to MangaCover composable
- Add Plumber to handle some system leaks automatically
- Add battery not low restriction for global updates

### Changed
- Release v0.14.0
- Update baseline profile
- Translations update from Hosted Weblate
- Update dependency androidx.activity:activity-compose to v1.6.1
- Center the Text inside `Pill`
- Alternate method of avoiding LazyColumn key conflict crashes
- Set source id when inserting to db
- Show file URI when invalid backup file is selected
- Cleanup history repository
- Refactor network to local manga logic
- Use new Compose BOM 2022.10.00
- Avoid some crashes
- Use Syer's Voyager fork
- Rework library selection
- Use `Channel` in Download cache
- Show LibraryScreen toolbar early to match other main screens
- Filter unsupported track service from available service list
- Don't export CrashActivity
- Fetch download counts if library is filtered by downloaded
- Use kotlin.time extensions in some more places
- Explicitly remove com.google.android.gms.permission.AD_ID permission
- Avoid NPE in browse source screen
- Only enable ACRA crash logging in preview and stable release builds
- Cleanup LibraryUpdateService
- Translations update from Hosted Weblate
- Category name letter casing change not allowed when renaming
- Cleanup UpdatesPresenter `deleteChapters`
- Handle async cache in updates and manga screens
- Tweak tablet UI mode setting
- Disable Firebase advertising ID collection
- Maybe avoid extensions list rendering crashes
- Avoid crashing during eager WebView init
- Avoid some IndexOutOfBoundsExceptions
- Prevent invalid user agent header values from being set
- Use fade transition in Voyager screens to mimic existing Conductor change handler
- Disable autocomplete on tracker login password field
- Perform download cache renewal async
- Proper DI instantiation for some more download related classes
- Allow disabling automatic backups for whatever reason
- Defer library download counts if not needed
- Translations update from Hosted Weblate
- Hide reader "Split tall images" option in release build
- Avoid crashing if invalid download and backup location is set
- Clean up strings and resources
- Update dependency com.google.android.material:material to v1.7.0
- Filter dynamic theme if it's not available
- Tweak library view
- Clean up OkHttp methods and parse from Okio directly
- More settings stuff
- Update serialization_version to v1.4.1
- Tweak Crash activity
- Move "Share" to end of DropDownMenu
- Update Baseline Profiles
- Always renew download cache if no sources have been loaded yet
- Tweak library query
- Tint icon with primary color and separate info item layout
- Select all options by default
- M3 and two pane ui
- Control library badge visibility with props instead
- Center EmptyScreen message
- Update aboutlib_version to v10.5.1
- Translations update from Hosted Weblate
- Update voyager to v1.0.0-rc02
- Update dependency com.google.firebase:firebase-analytics-ktx to v21.2.0
- Retain bookmark of readded chapters
- Tweak source view type menu radio icon to match stable
- Minor settings cleanup
- Full Compose settings
- Match display mode dropdown to stable and change toolbar icon based on display mode
- Move manga screen filter sheet to toolbar
- Minor cleanup
- Attempt to avoid duplicate update rows
- Range selection in library
- Update to AGP 7.3.1
- Use Compose's existing method to get plural string
- Upgrade to Kotlin 1.7.20
- Overwrite saved images instead of creating new ones
- Compose-ify and apply content padding
- Minor UI fixes
- Bring back overscroll in SwipeRefresh for A12+
- Don't wrap tab pills
- Document copied M3 component customizations
- Refactor SwipeRefresh and fix some issues
- Bump Compose Material3 dependencies
- Clean up download state logic in MorePresenter
- Update shizuku_version to v12.2.0
- Update dependency androidx.sqlite:sqlite-ktx to v2.3.0-beta01
- Hiding the keyboard
- Tablet UI edge-to-edge tweaks
- Allow marking partially read chapters as unread
- Allow manual selection of manga description instead of copying to clipboard
- Remove title
- Translations update from Hosted Weblate
- Reword some reader settings
- Setup Baseline Profile
- Show correct language string in browse screens
- Use argument for a `when` expression
- Update coil_version to v2.2.2
- Explicitly reword some locale names
- Revert min extension-lib change
- Update aboutlib_version to v10.5.0
- Stop loading extension-lib <= 1.2
- Move `LibraryManga` to domain layer
- Reduce some usages of `toDbManga`
- Don't trust index provided by source
- Don't download completely read chapter if it was in queue
- Remove paging
- Update Proguard rules to handle serializers in all modules
- Translations update from Hosted Weblate
- Tweak library search to allow for searching with source language suffix
- Tweak behavior on Browse screen
- Adjust item visual
- Improve DelayedTrackerStore
- Adjust insets
- Improve search toolbar UX a little bit
- Manga-refresh-state
- Fix selection state after deleting download
- Increase timeout duration of WebViewInterceptors
- Use more unique item keys
- Rephrase empty placeholder in clear database
- Update xml_serialization_version to v0.84.3
- Cleanup webview interceptors
- Bump minimum WebView version and default user agent string
- Temporarily replace library category tabs divider with our own
- Ellipsize long titles
- Adjust browse mode chips placement
- Split the rest of the preferences in PreferencesHelper
- Auto focus search view when initial query is empty
- Fix first active download status not updating
- Enable Gradle parallel mode
- Fix cold-start only lock behavior
- Bump dependencies
- Weblate translations
- Improve chapter recognition
- Move chapter preferences from PreferencesHelper to LibraryPrefrences
- Adjust source-api R8 rules
- Clear search query before popping controller when navigating up
- Recreate reader settings when opening sheet
- Split backup preferences from PreferencesHelper
- Minor cleanup
- Replace deprecated SmallTopAppBar
- Bump dependencies
- Split download preferences from PreferencesHelper
- Update BrowseSourcePresenter.kt
- Split track preferences from PreferencesHelper
- Split reader preferences from PreferencesHelper
- Cleanup logic in UpdatesPresenter
- Split library preferences from PreferencesHelper
- Clean up UpdatesController
- Replace clear database FAB with button
- Clean up base classes
- Catch error properly when app update check fails
- Minor cleanup/fixes
- Split security preferences from PrefrencesHelper
- Avoid invalid locales in language picker
- Read metadata from ComicInfo.xml files in Local source
- Split source preferences from PreferencesHelper
- Update dependency com.google.gms:google-services to v4.3.14
- Use 1.x preference abstraction
- Translations update from Hosted Weblate
- Upgrade AGP 7.3.0
- Use StateFlow for extensions list
- Always attempt automatic backup creation
- Extract source api from app module
- Revert compose-theme-adapter
- Fix equality check
- Flatten available extensions with its source
- Prevent okhttp from caching covers and chapter images
- Change logic in `BitmapFactory.Options.splitData`
- Check the actual folder when deleting source folder in case of stale cache
- Revert "Update Compose Material3"
- Count the downloads under each header instead of count the number of headers
- Update Compose Material3
- Bump dependencies + linting
- Update coil_version to v2.2.1
- Revert moving arrays to i18n
- avoid PR builds for translations
- Extract translation from app module
- Cleanup logic of `onStripSplit` in WebtoonPageHolder 2
- Weblate translations
- Revert removing Fullscreen theme
- Partial Compose conversion
- Cleanup logic of `onStripSplit` in WebtoonPageHolder
- Create cover file if it doesn't exist
- Use Scaffold
- Bump default user agent string
- Translations update from Hosted Weblate
- Translations update from Hosted Weblate
- Webtoon Split: Improve performance
- Update dependency com.google.firebase:firebase-analytics-ktx to v21.1.1
- Reimplement extensions search
- Rebase Scaffold fork
- Merge Latest and Browse into one screen
- Lessen the use of GlobalScope `launchIO`
- Adjust app lock mechanism
- Cleanup chapter name when syncing chapter with source
- Weblate translations
- Bump OkHttp and re-enable fast fallback
- Resolve review comments for BrowseSourceScreens
- Make top app bar lift behavior more consistent
- Maybe fix extensions list crash
- Clean up interceptors a bit
- Don't update page progress and allow preload when on StencilPage
- Manually handle HTTP 103 through WebView
- Minor cleanup
- Use Compose on BrowseSourceScreens
- Update dependency com.google.android.material:material to v1.7.0-rc01
- Implement nicer UI for migrate list sorting
- Initial conversion of browse tabs to full Compose
- Enable sub-languages on app first run
- Rewrite RateLimitInterceptor
- Rename source download folder on source rename
- Reword "All" source/ext lang to "Multi"
- Convert settings main and search views to full Compose
- Convert extension details to full Compose
- Update chapter progress upon registering tracker
- Show number of unique library items
- Tweak flag classes for Library
- Update dependency org.jsoup:jsoup to v1.15.3
- Long strip split fixes 2.0
- Update dependency com.google.android.material:compose-theme-adapter-3 to v1.0.17
- Long strip split fixes
- Prevent unofficial exts from getting marked as obsolete or updateable
- Minor cleanup
- Long Strip Split for Webtoon
- Weblate translations
- Bump dependencies
- Bump Compose M3 to 1.0.0-beta01
- Trim newlines from user agent
- Minor tweaks to download custom dialog
- Move a few Dialogs to Compose
- Download ahead
- Reorder themes
- Update serialization_version to v1.4.0
- Update coil_version to v2.2.0
- New Theme Tidal Wave
- Remove duplicate in valid chapter dir name list
- Disable explicit nulls for JSON serializer
- Log real requests and responses
- Fix race condition when applying sort mode
- Don't allow setting blank user agent string
- Simplify split tall images preference wording
- Update default user agent string
- Set initial flag on new categories
- Lint changes
- Reinstate in-app language picker
- Merge branch 'patch'
- Merge branch 'patch'
- Update checkbox icons to match latest Material lib
- Update com.google.android.material
- Update dependency androidx.sqlite:sqlite-ktx to v2.3.0-alpha04
- Use custom LazyColumn with animation fix
- Use application context to create toast
- Prevent unnecessary screen recompose
- Fix inset related issue
- Use the new image picker when available
- Weblate translations
- Some tweaks on Updates screen
- Fix crash on back pressed
- Change usage of name to visualName when Default category can be shown
- Change return value of `SyncChaptersWithSource.await()`
- Revert Glance to 1.0.0-alpha03
- Bump dependencies
- Use concurrency to cancel duplicate workflow runs
- Tweak Library screen
- Fake library loading
- Log extension loading errors directly
- Fix incorrect range selection
- Update .editorconfig
- Set readStartTime when switching chapters in a single reader session
- Glance widget fixes
- Update dependency gradle to v7.5.1
- Update aboutlib_version to v10.4.0
- Minor fixes
- More backup/restore code cleanup
- Weblate translations
- Start cleaning up backup/restore code
- Make screen loading indicators more consistent
- Move default category into database
- Bump AGP and Compose compiler dependencies
- Fix crash on first launch
- Save read duration to backup
- Reimplement appbar color overlay on scroll
- Minor gradle cleanup
- Update conductor_version to v3.1.7
- Glance widget for Updates
- Filter out empty genres before saving manga to database
- Dismiss clear database confirm dialog on success
- Fix early exit condition for readded chapters
- Update dependency ch.acra:acra-http to v5.9.6
- Mimic M3 rounded tab indicators
- Weblate translations
- Use Compose on Clear Database screen
- Use Stable interface for Updates screen + Cleanup
- Library category page performance fixes
- Bump dependencies
- Merge GetExtensions and GetExtensionUpdates
- Add distinctUntilChanged to db flow
- Bump dependencies and remove some unneeded opt-in compiler flags
- MangaScreen large UI tweaks
- Retain backstack views by default
- Wait for library to load before creating Pager
- Use non nullable parameters in the MangaCover invoke function
- Make Selection toolbar take precedence over search toolbar
- Fix broken page after opening manga
- Use SharedFlow for available extensions to always emit the value
- Optimize further and reimplement error state
- Tweaks on Library screen
- Don't update fav state when changing categories
- Set splash screen ready state for history and updates pages
- Avoid catastrophic failure when cover can't be created in local source
- Show better error when trying to open RARv5 file
- Bump to Kotlin 1.7.10
- Weblate translations
- Use Stable interface for History screen
- Cleanup Library after Compose changes
- Use Compose for Library screen
- Migrate More screen to full Compose
- Misc cleanup
- Save selection state
- Migrate Updates screen to compose
- Update dependency gradle to v7.5
- Migrate more screens to full Compose
- Avoid crashes due to SQLite support in older Android versions for debug builds
- Migrate licenses screen to full Compose
- Consolidate badge components
- Tweak categories view
- Consolidate Compose content/theme setting
- Incognito and downloaded only label related tweaks
- Minor library view cleanup
- Use Flow in ExtensionManager and SourceManager
- Use Compose for Library list and grid
- Use Stable interface for Browse screens
- Weblate translations
- Use MangaImpl defaults in Manga.create()
- Bump dependencies
- Make default user agent string configurable
- Little cleanup for stub source
- Use Material Icons for untrusted extension's icon
- Replace some usages of RxJava
- Always fetch chapter from source if current chapter is empty
- Fix unofficial extension has update
- Replace deprecated ACTION_MEDIA_SCANNER_SCAN_FILE intent
- Configure SQLite
- Set content descriptions for bottom nav badges
- Improve chapter list scrolling performance
- Bump to compile SDK 33
- Fixes and improvements
- Ditch the expanded app bar
- Use Compose for Category screen
- Weblate translations
- Fix scroller consuming touch when it's invisible
- Use Material3 switches in XML layouts
- Merge branch 'patch'
- Reset lastPageRead when chapter is marked unread
- Update default user agent string
- Ensure uniform hit area
- Increase height of transition view in webtoon viewers
- More domain model usage
- More domain model usage
- More domain model usage
- Cleanup data layer
- More domain model usage
- More domain model usage
- Use SQLDelight for all Manga related queries
- Update dependency com.google.gms:google-services to v4.3.13
- Update dependency com.squareup.okio:okio to v3.2.0
- Update styfle/cancel-workflow-action action to v0.10.0
- Update dependency ch.acra:acra-http to v5.9.5
- Update dependency com.google.android.material:compose-theme-adapter-3 to v1.0.14
- Use SQLDelight for all MangaCategory related queries
- Use SQLDelight for all Chapter related queries
- Migrate to more use of domain models
- Use SQLDelight for a Category related queries
- More SQLDelight migrations
- Replace package with namespace
- Use SQLDelight on Library screen
- Optimize split tall image
- Reimplement chapter download indicator longpress
- Weblate translations
- Hide scroller when appbar is expanded
- Use SQLDelight on Updates screen
- Revert some KTX extension changes
- Downgrade to Compose 1.2.0-rc03
- Only provide necessary info and not whole chapter/manga class
- Reuse components between two layouts
- Bump dependencies
- Extension API: change fallback source and logic
- Add description placeholder
- Improve history screen scrolling perf
- Sort Manga by title in `MigrationMangaScreeen`
- Ignore canceled calls
- Migrate usages of SyncChaptersWithTrackServiceTwoWay
- Migrate more track DB calls to SQLDelight
- Update issue templates
- Use sqldelight for direct db calls in `MangaPresenter`
- Fix action mode download button not working
- Fix incorrect touch target
- MangaInfoHeader tweaks
- Disable automatic translation merges
- Fix state updates when opening a new manga entry
- Update com.google.android.material
- Avoid overflow in extension screen items
- Use primary color for excluded tristate filter icon
- Minor cleanup
- MangaController overhaul
- Weblate translations
- Convert to compose
- Bump dependencies
- Use sqldelight in migration
- Utilize more KTX extensions
- Minor cleanup
- Convert cover dialog view to compose
- More minor refactorings
- Minor composable updates
- Migrate some categories SQL calls to SQLDelight
- Single source of truth and use new manga class
- Make stub source icon part of `SourceIcon`
- Migrate duplicate manga check to SQLDelight
- Update actions/dependency-review-action action to v2
- Use custom QueryPagingSource
- Top bar status indicator adjustments
- Convert edit cover function to suspend function
- Delete unused database queries/resolvers
- Weblate translations
- Change the workaround for title alpha
- Fix incorrect UI states when activity recreated with dialog controller
- Don't set text colors when creating compose theme
- Use SQLDelight on Category screen
- Update Compose
- Make Compose overflow menu feel slightly more like XML version
- Bump dependencies
- Minor cleanup
- Maintain source info in the database.
- Set db chapter metadata from correct chapter
- Use SQLDelight in Backup/Restore
- Update okhttp_version to v4.10.0
- Minor cleanup
- Update manga metadata on library update with `sqldelight`
- Update compose-theme-adapter
- Make `syncChaptersWithSource` use sqldelight
- Convert clear database queries to SQLDelight
- Weblate translations
- Actually compare chapter numbers as numbers when sorting
- Change cover memory key
- Update ChapterSourceSync.kt
- Make `ChapterRecognition` return the result
- Minor cleanup
- Don't show clipboard copy confirmation toast on Android 13 or above
- Tweak extension details screen
- Update dependency androidx.sqlite:sqlite-ktx to v2.3.0-alpha03
- Use Requery to enhance SQLite
- Bump dependencies
- Minor cleanups
- Migrating titles maintains custom covers
- Set default timestamp to max timestamp
- Adjust merge criteria for translation PRs
- Weblate translations
- Adjust merge criteria for translation PRs
- Weblate translations
- Configure Mergify to automatically merge translations PR every week
- Replace history query with actual upsert
- Update coroutines_version to v1.6.2
- Update aboutlib_version to v10.3.0
- Make Storio follow new database table structure
- MangaUpdates tweaks
- Minor cleanups
- Save reading progress with SQLDelight
- Downgrade R8 to avoid extension issues
- Move SQLDelight Gradle plugin to version catalog
- Mention MangaUpdates in README
- Adjust R8 optimization configs to fix extension issues
- Update AGP for Android Studio Chipmunk 2021.2.1 Patch 1
- Minor cleanup
- Local Source - qol, cleanup and cover related fixes
- Migrate settings search view to Compose
- Refactor chapter recognition tests to run in parallel
- Bump dependencies
- Minor cleanup
- Update extension details screen design
- Migrate extensions language filter screen to compose
- Combine build and test tasks in workflows
- Make extension list update when languages changes
- Run unit tests during CI builds
- Bump dependencies
- Convert ic_untrusted_source icons to WEBP
- Change jsDelivr CDN URL to Fastly
- Theme Compose SwipeRefresh indicator like XML version
- Reword reset viewer flags settings
- Minor cleanup
- Use jsDelivr as fallback when GitHub can't be reached for extensions
- Migrate extension details page to Compose
- Convert Extension tab to use Compose
- Update serialization_version to v1.3.3
- Update dependency com.fredporciuncula:flow-preferences to v1.7.0
- Settings cleanup
- Update aboutlib_version to v10.2.0
- Update to AGP 7.2.0 again
- Temporarily downgrade AGP to fix extension loading issue in non-debug builds
- Weblate translations
- Minor cleanup in `ImageUtil` and `SourceFilterPresenter`
- Update AndroidX SQLite
- Save reader progress when activity is paused
- Update reset viewer flags strings
- Detect identical mangas when long pressing to add to library
- Update Compose
- Minor cleanup
- Bump dependencies
- Configure Renovate
- Minor dependency updates
- Update linter
- Update build workflow actions
- Update to Coil 2.0.0
- Minor cleanup
- Check for app updates by comparing semver
- Extract add duplicate manga dialog into a controller
- Use theme primary color for slider track
- Don't save categories in backup if not selected
- Rename "navigation layout" to "tap zones"
- Adjust inset consumption in Compose controllers
- Don't allow swiping away app update install notification
- Minor cleanup
- Reword and Fix library sort
- Case insensitive sort in Source tab
- Properly modify StateFlow value
- Properly show history state
- Extract migrate list number badges for later use in library items
- Make `MigrateSourceState` similar to `MigrateState`
- Make `SourceState` similar to `MigrateState`
- Notify user of error during a page download failure
- Update navigation bar padding in Compose screens
- Migrate Source Filter Screen to Compose
- Allow passing modifier to preference composables
- Migrate Migrate Manga screen to Compose
- Use Compose for OAuth login loading indicator
- Update compiler flag args
- Center `CurcularProgressIndicator` in `LoadingScreen`
- Use Compose in Migrate tab
- Migrate SettingsMainController to Compose
- Update Kotlin and Compose
- Download new chapters when only excluded categories is selected
- Throw out old unit tests
- Adjust download menu item positioning
- Adjust library sorting by dates
- Default to downloading as CBZ
- Minor cleanup 2: Electric Boogaloo
- Minor cleanup
- Convert Source tab to use Compose
- Migrate WebViewActivity to Compose
- Delete entire app_webview folder when clearing WebView data
- Weblate translations
- Migrate More screen to Compose
- Tweak about preferences styles
- Clean up repetitive controller transactions
- Basic initial port of About screen to Compose
- Resume when history item is tapped
- Lifted NestedScrollConnection to abstract Compose classes
- Move clear webview data action to network group
- Migrate open source licenses screen to Compose
- Revert "Revert history Compose/SQLDelight changes"

### Fixed
- Fixed "0 mins ago" in "Library last updated" string
- Fix app lock and make delay not survive app being killed
- Fix "Add manga to library" snackbar not showing with ChapterDownloadAction.START_NOW
- Fix language/theme settings dialog and remove delay
- Fix crash when saving a page from certain chapters
- Fix download cache not updating on location change
- Fix selection in library
- Fix empty screen font style
- Fix download progress indicator
- Fix Scrollbar when the list contains sticky header
- Fix linting error
- Fix filter search not triggering when clicking genre from Manga details
- Fix sort by date in LibraryPresenter
- Fix regular scrollbar
- Fix ComicInfo.xml not being read if .noxml file exists too
- Fix total item count in library app bar
- Fix missing focus when single TextField shown
- Fix date added when adding from browse source
- Fix error when updating manga details with uninitialized title
- Fix library search not being reflected
- Fix always-on app lock on cold start
- Fix manga being reinitialized in browse
- Fix stacking of Settings menu in the reader on multiple taps
- Fix missing condition on `getLibrary` sql query
- Fix derivedStateOf errors
- Fix lint error
- Fix download ahead missing out 1 chapter
- Fix Filter not being applied in Browse Source
- Fix missing downloaded only/incognito banners in Browse Source
- Fix missing downloaded only/incognito banners in Browse
- Fix tmp cbzs are counted towards manga download count
- Fix webtoon viewer pages not loading
- Fix choosing regionalized locales
- Fix IndexOutOfBoundsException when using Split tall images
- Fix overflow in ChangeCategoryDialog
- Fix issue with removing categories from manga for ChangeCategoryDialog
- Fix issue with input for DownloadCustomChaptersDialog
- Fix checkbox selection when tapping text in Compose dialogs
- Fix chapter download with empty scanlator
- Fix stucked downloads when service not started
- Fix crash when opening library sheet with empty category list
- Fix nav bar appearing when going from Library's action mode
- Fix emoji going crazy and fix tabs being visible when library is empty
- Fix notification and add visual cues when triggering a second update
- Fix download chapter dir when scanlator is empty or changed
- Fix crash when setting cover errors
- Fix issues related to Manga screen slow load
- Fix default category showing up in edit manga categories list
- Fix appbar action content descriptions
- Fix null pointer exception on Extension Detail screen
- Fix Clear Database item trying to display language when empty
- Fix logic for searchWithGenre
- Fix library bugs
- Fix number of items not updating when Show category tabs is off
- Fix category exclude not working in DownloadManager
- Fix wrong query being used when opening Global Search
- Fix infinite loading when user library is empty
- Fix toolbar having bottom padding in portrait
- Fix unnecessary recompose when calling LazyListState.isScrolledToEnd
- Fix crash in Extension Detail and set ready to true on Library screen
- Fix padding in history screen
- Fix logic of app unlock
- Fix image MIME issues that cause download errors
- Fix download status not updated properly after starting batch download
- Fix concurrent download
- Fix tablet manga screen column ratios
- Fix library column setting jumping in
- Fix Library List not using correct text color
- Fix extension setting isn't accesiable when it has update
- Fix crash with chapterFlags in Manga.create()
- Fix bug in default category downloading logic
- Fix scroll animation when system animation is disabled
- Fix MangaScreen app bar title and nav icon action
- Fix default category name
- Fix auto downloader for "Default" category
- Fix broken downloaded chapter
- Fix unit test class to match package
- Fix chapter item incorrect colors
- Fix crash when adding if there are more then 1 dupe
- Fix `Mark previous as read`
- Fix trackers not migrating
- Fix app update install notification disappearing
- Fix clicking cover opening random manga
- Fix chapter number display style
- Fix manga info header using wrong text color
- Fix downloader crash related to UnmeteredSource
- Fix crashes from KTX extension changes
- Fix accented UI elements in library sheet being different colors
- Fix cover fetching in compose views
- Fix History not being added when restoring backup
- Fix freezing on migrating manga
- Fix WebView user-agent
- Fix wrapped long page numbers in reader
- Fix chapter list live update
- Fix Links to Changelog/Readme/Commits for `multisrc`
- Fix loading progress not showing in webview
- Fix global update ignoring network constraint
- Fix wording in issue template
- Incorrect sorting when chapter name contains hyphens '-'
- Fix `LogPriority` in `HistoryRepositoryImpl`
- Fix reader menu appearing then disappearing in webtoon viewer when there is no next chapter
- Fix webtoon viewer showing transition view when going to next/prev chapter using next/prev button
- Fixed Splitting Height for Tall Images
- Fix close button tint in extension screen
- Fix both warning banner appearing for unofficial ext
- Fix formatting
- Fix category tabs incorrect scroll position
- Fixed splitting logic and CBZ compression logic
- Fix "Move to top" showing at the most top item in download queue
- Fix download splitter potentially throwing OOM on huge images
- Fix crash when using renamed library sort methods
- Fix tall image split math issues
- Fix removing manga from library reverts during global update
- Fix migrations
- Fix database corruption
- Fix Android 13 icon sizing
- Fix about icons sizing
- Fix crashing in Android 13 Beta 1
- Fix skipped library entries and size warning notifications using same ID
- Fix update warning notifications being cut off
- Fix chapter transition setting for one page chapters

### Removed
- Remove side nav icon alignment preference
- Remove unnecessary swap file
- Remove fake chapter deletion state updates
- Remove redundancy in ExtensionManager
- Remove ben-manes.version plugin
- Remove dead code
- Show manga title in dialog message
- Remove obscure/barely translated locales
- Remove mangaChapterMapper
- Remove cache control on already cacheless image request
- Remove Tagalog translations
- Remove redundant preference keys
- Remove some dead code
- Remove unused resources
- Remove unused resources
- Remove download source folder when empty
- Remove some usages of global scope
- Remove Duktape
- Remove 1.x source models
- Remove some unneeded TODOs
- Remove unused viewstatepageradapter dependency
- Remove deprecated LibrarySort
- Remove unused dependencies
- Remove unused menus and drawables
- Remove unused legacy ActionModeWithToolbar
- Remove bottom nav behavior and add bottom padding to root controller contents
- Remove top app bar scroll behavior
- Remove SQLiteOpenHelper as database is migrated to SQLDelight
- Remove more unused StorIO code
- Remove unused database resolvers/queries
- Remove CI-specific Gradle config
- Remove logic for restoring legacy JSON backups
- Remove source lang on migrate screen also seperate removed source on alphabetical sort
- Remove unused drawables
- Remove some minor settings
- Remove some unused StorIO queries/resolvers
- Remove unused preference layouts

## [0.13.6] - 2022-08-14

### Added
- Add auto split tall images setting
- Add missing `Authorization` header on MAL refresh token request
- Add downloaded icon in TransitionView when chapter is downloaded

### Changed
- Release v0.13.6
- Don't allow swiping away app update install notification
- Detect identical mangas when long pressing to add to library
- Actually compare chapter numbers as numbers when sorting
- Migrating titles maintains custom covers
- Log extension loading errors directly
- Filter out empty genres before saving manga to database
- Avoid catastrophic failure when cover can't be created in local source
- Show better error when trying to open RARv5 file
- Make default user agent string configurable
- Replace deprecated ACTION_MEDIA_SCANNER_SCAN_FILE intent
- Configure SQLite
- Use Material3 switches in XML layouts
- Bump dependencies + compile SDK to 33 + linting
- Update .editorconfig
- Update chapter recognition and related tests
- Update AGP/Gradle

### Fixed
- Fix sources not loading
- Fix Links to Changelog/Readme/Commits for `multisrc`
- Fix logic for searchWithGenre
- Fix logic of app unlock
- Fix image MIME issues that cause download errors
- Fix concurrent download

### Removed
- Remove deprecated LibrarySort

## [0.13.5] - 2022-07-08

### Added
- Add MIME type mapping for image/jxl
- Add new "Lavender" theme
- Add more DoH providers
- Add ability to show manga when clicking item in migration search process
- Add switch to DownloadPageLoader when chapter is downloaded
- Add `-r` flag to ShizukuInstaller `createCommand`
- Add links to website FAQ for library update and download warning notifications
- Add battery not low restriction for global updates

### Changed
- Release v0.13.5
- Bump dependencies
- Update default user agent string
- Increase height of transition view in webtoon viewers
- Extension API: change fallback source and logic
- Ignore canceled calls
- Use primary color for excluded tristate filter icon
- Don't show clipboard copy confirmation toast on Android 13 or above
- Set default timestamp to max timestamp
- Local Source - qol, cleanup and cover related fixes
- Change jsDelivr CDN URL to Fastly
- Use jsDelivr as fallback when GitHub can't be reached for extensions
- Save reader progress when activity is paused
- Update build workflow actions
- Check for app updates by comparing semver
- Use theme primary color for slider track
- Don't save categories in backup if not selected
- Rename "navigation layout" to "tap zones"
- Download new chapters when only excluded categories is selected
- Default to downloading as CBZ
- Delete entire app_webview folder when clearing WebView data
- Move clear webview data action to network group

### Fixed
- Fix cherry pick errors
- Fix downloader crash related to UnmeteredSource
- Fix accented UI elements in library sheet being different colors
- Fix wrapped long page numbers in reader
- Fix global update ignoring network constraint
- Fix reader menu appearing then disappearing in webtoon viewer when there is no next chapter
- Fix webtoon viewer showing transition view when going to next/prev chapter using next/prev button
- Fix category tabs incorrect scroll position
- Fix "Move to top" showing at the most top item in download queue
- Fix removing manga from library reverts during global update
- Fix Android 13 icon sizing
- Fix skipped library entries and size warning notifications using same ID
- Fix update warning notifications being cut off
- Fix chapter transition setting for one page chapters

## [0.13.4] - 2022-04-22

### Added
- Add advanced setting to clear WebView data
- Add indexes to creational tables
- Add abstract ComposeController
- Add placeholder color for Compose manga covers
- Add elevation to navigation rails

### Changed
- Release v0.13.4
- Revert history Compose/SQLDelight changes
- Temporarily remove chapter name cleaning
- Enable verbose logging in dev flavor by default
- Lift Compose theme to abstract controller
- Simplify history item description building
- Default auto backups to 2
- Migrate History screen database calls to SQLDelight
- Make links in new update dialog clickable
- Replace ignore button in new update dialog with link to GitHub page
- Update junrar
- Move chapter name cleaning logic to holder
- Show better error message when empty backup creation is attempted
- Increase default OkHttp call timeout to 2 minutes
- Show parsed Markdown for new version info
- Migrate History screen to Compose

### Fixed
- Fix crash on History tab when there is no next chapter
- Fix AppBar not unlifting when scrolling using ComposeView

## [0.13.3] - 2022-04-15

### Added
- Add dependency review step to workflows
- Add clear cookies option to WebView menu

### Changed
- Release v0.13.3
- Weblate translations
- Always remove manga title from if it prefixes chapter names (related to #6913)
- Limit package name overriding to Android 8+ (related to #6846)
- Bump Material Components
- Update F-Droid migration guide link
- Adjust update/download warnings
- Set network call timeout to 90 seconds (instead of infinite)
- Rollback to stable OkHttp
- Avoid some crashes
- Minor cleanup
- Avoid crashing if picture can't be saved (related to #6905)
- Update Skip Updating preference strings.
- Update ACRA
- Show different update notification for F-Droid installations
- Move learn more text in skipped entries notification to main content
- Stop allowing keeping app data on uninstall
- Update Coil
- Update ACRA

### Fixed
- Fix cover sharing error string

### Removed
- Remove dependency review step from push workflow
- Remove build flavor checks for update warnings

## [0.13.2] - 2022-04-10

### Added
- Add option to disable navigation layout
- Add missing percent placeholder in some singular strings.
- Add "Move all chapters from series to top" option to download context menu
- Add support for Happy Eyeballs
- Add cover error drawable
- Added reverse portrait reader rotation
- Add shortcut to change app language in Android 13
- Support Android 13 themed app icon
- Add shortcut to edit categories screen from category setting dialog
- Add Prerequisites and Getting help to Contributing.md
- Add "Started" library filter and library update restriction
- Add Quad9 DOH provider
- Add shortcut to backups guide
- Add 5% webtoon reader side padding option

### Changed
- Release v0.13.2
- Gate update/download warnings to non-stable flavors
- Update to AGP 7.1.3
- Weblate translations
- Formatting
- Ensure media store scan is triggered after saving an image
- Update linter
- Move delete action to match placement in library_selection.xml
- Handle moving cover cache after adding to library
- Bump to Gradle 7.4.2
- Bump dependencies
- Write library cover to library cover cache
- Don't close network response
- Update WebView requester package name
- Override X-Requested-With header value in WebView requests
- Update Coil
- Base activities cleanup
- Stop global search items from clipping
- Use source's header for network request
- Force default browser for tracker logins
- Stop using custom tabs
- Stop removing local manga's title from chapter names
- Update dependencies
- Weblate translations
- Don't init adapter until chapter data is ready
- Update Material Components
- Use the file extension from the ImageType enum
- Share logic for saving page/cover
- Avoid crashing when global search encounters a NoClassDefFoundError
- Require WebView v95+
- Avoid throw as it is slow expensive operations
- Revert "Add shortcut to change app language in Android 13"
- Reduce anim duration when launched from resume FAB
- Disable app cache WebView (is a deprecated web API and is being removed in Android 13)
- Split out global library update skipped entries into separate notification
- Avoid potentially deleting the entire backups folder
- Copy raw description on long tap
- Change cover placeholder
- Minor cleanup
- Recreate Backup worker with IS_AUTO_BACKUP_KEY flag
- Use same name for manual backup job tag and work name
- Update AGP and Gradle
- Coil 2.x upgrade
- Use Version Catalog & clean up Gradle files
- Use existing worker for manual backup creation
- Adjust mark as unread and mark previous as read action visibility
- Move auto-closer rules
- Update Material Components
- Adjust badge font weights
- Restore bottom nav position earlier after being recreated
- Side padding: Added missing percentage
- Reword library update restrictions setting and surface skipped entries in error notification/log
- Avoid some crashes if router backstack is empty for whatever reason
- Grid items optimizations
- No need for a new bit for DisplayModeSetting mask
- Consistent divider colour
- Update action_display_cover_only_grid string
- Weblate translations
- Update Theme Preview Items
- Cover only grid added to library
- Rename extension function to avoid confusion with androidx function
- Navigate to pan / landscape zoom
- Detect identical mangas when adding to library
- MainActivity fixes
- Update dependencies
- Update AGP for Android Studio Bumblebee | 2021.1.1 Patch 1
- docs: update app update checker link
- Disallow PackageInstaller extension installer option on MIUI
- Allow disabling secure screen when incognito mode is on
- Don't show error toasts in MangaController for HTTP 103 responses
- Increase minimum required disk space to download chapters to 200MB
- Update versions plugin
- Filter archive files as sequence
- Display correct string on FAB
- Unify reader error layout
- Fix transition crash on Android 8
- Revert "Temporarily revert some things for stable release"

### Fixed
- Fix DST issue
- Fix clear database selection toggling
- Fix filename not having chapter title and page when sharing
- Fix extension update badge reset when app resumed
- Fix off by 1 dates
- Fixed the wrong offset
- Fix corrupted backup file, fix #6424
- Fix "Landscape zoom" and "Navigate to pan" for split images
- Fix overlap between DisplayModeSetting and SortModeSetting masks
- Fix Quad9 DoH setting

### Removed
- Remove reader tapping option in favor of disabled nav layouts
- Remove some dead code
- Remove kotlin.compiler.execution.strategy config
- Remove source filter sheet solid background
- Removed scrollbar on long theme item titles
- Remove unused string

## [0.13.1] - 2022-02-01

### Changed
- Release v0.13.1
- Temporarily revert some things for stable release
- Avoid unnecessary transition setup in reader if not transitioning
- Ignore inset visibility
- Avoid trying to open links in invalid Huawei app
- Update preference dependencies
- Update issue templates
- Use default bottom nav height
- Revert "Disable update/download warnings for stable release"

### Fixed
- Fix app crashing when opening ReaderActivity with FAB

## [0.13.0] - 2022-01-31

### Added
- add note about issue taking in contribution guide
- Add extra space before error in log description
- Add ability to open FAQ and Guide, and Changelog in extension repository
- Add new manga statuses
- Add DoH abbreviation to preference title so it's searchable
- Add QuickJS dependency to eventually replace Duktape
- Add compress to CBZ on download
- Add AppInfo functions to replace BuildConfig usages in extensions
- Add link to troubleshooting guide in library update error log file
- Add Better Extension Search
- Address some IDE warnings
- Add option for library update only update completely read manga
- Add link to privacy policy
- Add download action to New Chapters Notification
- Add sui support
- Add convenience extension functions for rate limit interceptors
- Add UnmeteredSource interface
- Add tertiary badge in appearance preview
- Add divider under extension details header
- Add ability to clear cookies per-extension
- Add feature to clear database manga by source
- Address some Android lint warnings
- Added tabletUI option: "Automatic"
- Add badge to bottom bar Updates tab indicating how many unread chapter updates are available
- Add notification action to open GitHub release page
- Add ability to copy a genre/tag to clipboard by long-pressing it's chip
- Add migration to add "all" to enabled langauges
- Add some info about automatic backups
- Add warnings when library and download queues are considered large
- Add new build type for weekly preview

### Changed
- Release v0.13.0
- Disable update/download warnings for stable release
- Weblate translations
- Fix incomplete description on tablet ui
- Avoid invalid unset default browser
- Always try to use default browser when opening custom tabs on all Android versions
- Use insetter to handle inset
- Tweaked Yin & Yang theme a little
- Copy source ID to clipboard when long pressing source in migrate list
- Try to show more relevant exception messages when failing to restore a backup
- Discard backup file if it fails to be created properly (e.g. fails validation)
- Show error toast if empty URI is passed when trying to create/restore a backup
- Write job failure exceptions to error log
- Update to AGP 7.1.0
- Replace custom download dialog buttons with MaterialButtons
- Allow choosing browser apps from WebView even when extension deep links are verified in Android 12+
- Avoid migration failing if previous source doesn't exist
- Allow Samsung devices on Android 12+ to use dynamic theme
- Spacing adjustments in reader settings sheet
- Weblate translations
- Revert "Update core-splashscreen "
- Update dependencies
- Update core-splashscreen
- Drop first search event
- Don't apply appbar padding on tablet ui
- Change library list item title style
- Update crop border shortcut state when reading mode or manga set
- Change Toolbar to MaterialToolbar
- Make tracker status wording/ordering more consistent
- Avoid reader crash
- Update to Conductor 3.1.2
- Reduce stutter when entering Browse screen
- Use material components on reader error views
- Fallback to preference title if dialog title isn't set
- URL encode Kitsu search queries
- Replace use-experimental Kotlin compiler flags with opt-in
- Custom Cloudflare failure exception to avoid user-facing "java.lang.Exception" text
- Avoid crashes in tracker interceptor errors
- Handle renaming existing downloaded CBZ chapters on update
- Weblate translations
- Move preference extension functions to utils
- Update versions and about libraries plugins
- Swallow observable errors instead of crashing
- Update analytics dependencies
- Update wording of `pref_remove_after_marked_as_read`
- Actually Fix #6341
- Reduce redundancy in some preference declarations
- Update "Library updates restrictions" wording
- Use animation to hide/show fab
- Truncate MAL search queries to first 64 characters
- Case insensitive sort in extension list.
- Avoid unnecessary string creation when sorting
- Don't recompute constant device info
- Rename night theme color files too
- Rename theme color value files so they are not scattered
- Update dependencies
- Avoid crash on Samsung devices on Android 12
- Handle potentially missing sources list in extensions JSON
- Remove app bar lift mechanism for view pager
- Update some wording in Delete Chapters preference.
- Better Upload Date to not have a single blank upload date.
- Action toolbar adjustments
- Adjust global update preference wording and visibility
- update workflow actions
- Hide irrelevant settings if global update isn't enabled
- Refactor dependant preference visibility flows
- Combine global update item restrictions
- Workaround cleanup
- Update dependencies
- Use elevated overlay on reader menu
- Update to Kotlin 1.6.10
- Sfix some colors and going back to original pink-ish color
- Revert download notification icon changes
- Move custom brightness slider to top of filter sheet
- Refactor backup restore process to stop relying on file extension
- Show version name in new update notification
- Don't preselect any options in library remove manga/downloads dialog
- Update notification icons
- Update AGP and Gradle
- Apply dialog theme to Material Alert Dialog Theme
- Tweak Midnight Dusk colors
- Check if dynamic colors are available using official API
- Also call onBindEditText listener set by extension
- Automatically set tracker as completed after reading the last chapter
- Tabbed bottom sheet adjustments
- Apply elevation overlay to colored navbar
- Update dependencies
- Update gradle-command-action
- Avoid loading available extensions list if it seems too small
- Use default snackbar styles (fixes unreadable text)
- Throw exceptions if some of the deprecated source methods are used
- Allow loading extension-lib 1.3
- Update dependencies
- update issue-moderator-action
- Weblate translations
- Set IME input to use number only
- Change Tako dark elevation overlay color
- Tweak Teal & Turquoise color for new M3
- Partially migrate LocalSource to 1.x methods
- Clean up some tablet dimension values
- Update to Conductor 3.1.1
- Option to clear chapter cache when MainActivity is closed
- Tweak app theme preference selection
- Replace Resume FAB reveal animation with container transform
- Tweak relative date function
- Reinstate elevation overlay
- Rework the Library icon for the third time
- Update dependencies
- Clean up ActionMode styles
- Use outlined cards in tracker search
- Adjust manga genre chip style
- Adjust CardView styles
- Adapt App Themes to M3 Color System
- Adapt M3 Typography
- Only allow digits in custom download range dialog
- Initial pass of Material 3 styling
- Update dependencies
- Don't auto-download chapters if excluded but no categories selected
- Default to only updating non-completed manga
- Use sw720dp for tablet UI threshold
- Disable some unnecessary build features
- Update dependencies
- Avoid crashing when notification channels can't be created/deleted
- Disable updates badge by default
- Update metadata in same scope as the rest of library update (fixes #5702, probably)
- Clean up local source chapter name cleaning
- Move app and extension update notifications to new channels/group
- Move unread chapters badge setting to General section
- Extension "Update all" button
- Weblate translations
- Hide cutout toggle button if fullscreen is off
- Allow manga titles to update from source if they are not in library
- Validate backup during creation
- Update dependencies
- Change zoom from 3x to 5x
- More sensical string for 'pref_hide_threshold'
- Sync view state with controller on activity resume
- Minor cleanup
- Launch the download warning toast in the UI thread
- Change tablet UI threshold to w720dp
- Adjust update/download warnings
- [6068] - Use semibold text for Browse items primary text
- Minor cleanup
- Make tapping library update and backup restore error notifications open log
- Use natural ordering when sorting by chapter numbers
- Weblate translations
- Change global update unmetered connection restriction to connected to Wi-Fi
- Update dependencies
- Rename app updating classes
- Use default source filters in global search
- Avoid building PRs that only affect Markdown docs or string translations
- MangaController optimizations
- Update missing chapters warning
- Bump queue warning threshold to 60
- Update AGP
- Minor cleanup
- Handle HTTP 403 responses with CloudflareInterceptor
- Adjust update/download warning threshold
- Allow hiding "All" section in extensions list
- Reword missing chapters warning
- Use SwitchMaterial for preferences too
- Use single layout for grid badges
- Reword badge titles
- Require authentication to toggle showing NSFW sources
- Allow searching for multiple extensions at once
- Smaller font size for reader page indicator
- Grouped chapter download list by source
- [5893] - Implemented Language Badge
- Manga description adjustments
- Hide slider tooltip label everywhere
- Update dependencies
- [6059] - Pending downloads count on Download queue screen
- Replace Timber with Square Logcat and make logging configurable
- [5753] - Add pending downloads count on Download queue
- Weblate translations

### Fixed
- Fix selection state appearance in clear database list
- Fix bottom nav showing on resume when action mode is active
- Fix search inputs accepting formatted text
- Fix tab underline in chapter settings sheet
- Fix solid background behind text selection UI in dialogs
- Handle Komga tracks during manga migration
- Fix pages not being serializable for chapter cache
- Fix bottom nav being visible when resuming app
- Fix more crashes
- Fix crash in ReaderActivity
- Fix some crashes
- Fixes descriptive notification message for errors
- Fix Crash while trying to search in Settings
- Fix some crashes
- Fix crash for bound intListPreferences
- Fix incorrect locale name casing in extension details
- Fix Global Search ignoring incognito mode when setting last used source.
- Fix readded chapters polluting 'Updates' tab.
- Fix #6341
- Fix #6366
- fix thread locking workflow to actually be daily
- Fix back button having wrong tint in Toolbar
- Fix local source cover changing
- Fix MAL search novel filter
- Fix crash in clear database screen
- Fix colorFilterActive in Tako theme
- Fix library animation lag
- Fix overflowed action toolbar items
- Fix "Check for updates" not working due to time cooldown
- Fix SwipeRefresh initial position in MangaController
- Fix cutoff ripple for extension install cancel button
- Fix crash when updating library whithout manga to update
- Fix bottom nav sometimes appearing within navbar area
- Fix storing covers for local manga
- Fix what's new link in dialog
- Fix double increment when updating covers
- Fix crashing when clicking the search icon
- Fix reappearing indicator in the History tab
- Fix AppBar lift state when snapped
- Fix inset not applying when in landscape
- Fix MangaController fast scroller position
- Fix issues with NSFW sources setting
- Fix crash when deleting last item in library
- Fix Local and Other lang sources showing up in seperate Other Categories
- Fix stuck display mode for when not using per category setting

### Removed
- Remove more formatting span types in SearchView (maybe fixes #6495)
- Remove some dead code
- Remove clutter in main
- Remove unused Nsfw annotation
- Remove explicit option to store downloads in app data folder
- Remove library update order setting
- Remove Gson dependencies
- Remove unnecessary tab style
- Remove outline from download queue items
- Remove custom tab indicator style
- Remove legacy blue theme
- Remove unused fast scroll bubble drawable and accidentally committed file
- Remove translations of non-translatable strings
- Remove jcenter usage
- Remove global update intervals below 12 hours, add every 3 day interval
- Remove paused text when resuming downloads with info hidden

## [0.12.3] - 2021-10-04

### Added
- Add chapter bookmarking feature to Updates screen

### Changed
- Adjust Wi-Fi connection check (related to #6038)
- Release v0.12.3
- Weblate translations
- Formatting
- Enable "ALL" in Browse by default
- App-wide typography adjustments
- Sort and remove duplicates in genres
- Move item init to IO thread
- Switch to Material Slider in color filter settings
- Apply navigation bar insets to fast scroller and settings search list
- Check if wifi is connected rather than enabled while downloading.
- Update AboutLib plugin
- Switch to Material Slider for reader seekbar
- Update dependencies
- Don't bury sort menu in overflow in Migrate screen
- Ability to order sources by library count when migrating
- Move extensions enabled languages on top
- Block focus on viewer
- Revert parseAs inline function change
- Mark installer names as non-translatable
- Use data class to parse extensions list
- Update kotlinx.serialization
- Show message in migrate screen if library is empty
- Hide soft keyboard after submitting search query throughout app
- Implement new extension install methods
- Reattach after slight delay instead on every db update
- Update dependencies
- Toolbar and bottom nav scroll snap
- Adjust snackbar durations
- Minor cleanup
- Rewrite getFormat the kotlin way
- Move extension app info button
- Handle maxNumberSort from API
- Change how the bottom navigation is hidden
- Update issue closer to ignore myanimelist
- Allow preferences to multi-line
- Unify NSFW flagging for sources/extensions

### Fixed
- Fix crash in single-page chapters
- Fix MangaController toolbar title showing when editing category
- Fix incorrect appbar lift state when opening MangaController in hidden state
- Fix variable name in `isOnline`
- Fix setting search re-animating on activity recreation
- Fix toolbar title alpha

### Removed
- Remove extra padding when using list with Per Category setting
- Remove spaces at end of line before removing multiple new lines
- Remove setting to disable update error notifications and split out notification channel

## [0.12.2] - 2021-09-13

### Added
- Add link to help translate in about
- Add status icons to manga info
- Added a getting started guide action for when the library is empty
- Add IME_FLAG_NO_PERSONALIZED_LEARNING flag to text input when incognito is enabled
- Add a much more clean design to Chips
- Add haptic feedback to reader page slider
- Add a Pull Request template
- Add check for current controller before setting extension update tab badge
- Add Theme "Teal & Turquoise"
- Add toggle to invert page color in reader color filter settings
- Add in-app app update check
- Add ability to tweak auto hide sensitivity in Webtoon Reader

### Changed
- Release v0.12.2
- Weblate translations
- Don't count "other" as a language.
- Don't show option to delete chapters for local manga
- Update ExtensionPresenter.kt
- Minor cleanup for download delete exclusion
- Opt out of WebView metrics and disable Google Safe Browsing
- Reuse reader's image view in MangaFullCoverDialog
- Change ProtoNumber of Backup Models for History and Source to a non-zero digit
- Allow exclusion on Delete After Read per category
- Less hacky way to make sure bottom action toolbar doesn't scroll down
- During migration, only do MangaController replacement if previous controller is also MangaController
- Fix listeners cancelled when pushing new controller within
- Use chapter_number instead of ordinal index for syncChaptersWithTrackServiceTwoWay
- Title fixes
- Disable action mode status bar guard
- Use "isOnline" utils in DownloadService
- Read from streams for local source manga details and legacy backups
- Retain GLUtil.maxTextureSize
- Clean up some companion object usages
- Skip bookmark check when cancelling downloads
- Ensure all fields in new migrated manga are persisted
- Adjust padding of themes preference
- Avoid multiline library badges
- Queue tracking updates when offline
- Minor cleanup
- Don't allow focus on reader containers
- Hide language tag when only one language is used
- Weblate translations
- Retain scroll position when selecting app theme preference
- Rearrange themes, rename "Blue" to "Legacy Blue"
- Reword advanced tablet UI setting
- Edit  mangas' Categories in Library using TriState list
- Migrate to flow version of ReactiveNetwork
- Don't show update progress notifications if job isn't active anymore
- Update dependencies
- Tablet UI override
- Use ShapeableImageView for rounded thumbnails instead of Coil transformations
- Improve placement of manga title section
- Update Material Components
- Trim line breaks in manga info only when collapsed
- Handle small cover better
- Update kitsu to not show "null" for empty descriptions
- Make appearance settings searchable
- Clean up reader action sheet layout
- Update build release wording
- Update save icon
- Replace MotionLayout with full screen dialog
- Register TachiyomiImageDecoder after built-in Coil decoders
- Tweak theme preference item UI
- Rename Layout category to Navigation
- Only update chapter/viewer flags for library manga instead of everything
- Clean up track button changes
- Replace tick with button
- Change Track.last_chapter_read to Float
- Clean up imports
- Use more Compat utilities
- Tweak theme preference item UI
- Replace Wi-Fi connection check with WifiManager
- Apply system animation scale to parts of Tachiyomi that don't respect it by default
- Update Kotlin and Kotlinter
- Replace NetworkInfo with NetworkCapabilities
- Use NotificationChannelCompat utilities
- New manga info expander
- Split out appearance settings from general section
- Update app theme preference UI
- Make nav overlay non-clickable (maybe fixes #5727)
- Update deprecated Android Gradle DSL calls
- Update tracker services logo layout
- Move acknowledgements to bottom of issue templates
- Revert "Hardcode bottom nav height "
- Hardcode bottom nav height
- Use custom tabs instead of browser
- Minor cleanup
- Update release workflow to handle multiple ABI variants
- Update dependencies
- Bold author and artist fields
- Tweak MangaInfoHeader
- Move PR template
- Adjust blue theme
- Update Anilist tracking title during refresh
- Update jsoup
- Minor cleanup
- Use user preferred title language in Anilist
- Hide reader progress indicator right away
- Make default category translatable
- Require authentication-confirmation to change biometric lock settings
- Partial revert 914b686c8eaf3954e291355975532eb28662c38c
- Move chooseBackground call to IO thread
- Edge-to-edge manga details view
- Use context theme color for texts
- Label one-shots correctly in anilist track search
- Replace deprecated argument for gradle command action
- Use separate string for toRelativeString "Today"
- Use toRelativeString in Updates and History headings
- Update google-services.json with latest version from Firebase Console
- Use relative time in ChapterHolder
- Allow FilterList to be passed with default values
- DNS-over-HTTPS (Adguard)
- Split push and PR build workflows so they don't cancel each other
- Set expanded cover dimension ratio from the source image
- Update menu icons in Browse Sources view
- Don't allow focus on ReaderNavigationOverlayView (maybe fixes #5555)
- Open tracker page when clicking logo
- Always re-setup background jobs on migration runs
- Do background app/extension checks less frequently
- Update dependencies
- Apply app theme styling to reader page errors and progress dialog
- Update documentation
- Update to Contributor Covenant 2.1
- Use correct color for reader loading indicator
- Enable elevation overlay for MaterialSwitch
- Replace AboutLibraries activity with custom controller
- Reorganize dependencies a bit
- Update Duktape
- Merge branch 'fix-12' into master
- Update issue templates
- Re-enable preview build things

### Fixed
- Fix scroller getting dragged incorrectly in RTL
- Fix manga info expand button background
- Fix crash in settings search
- Fix chapters getting deleted when marking as unread from library
- Fix MangaController's loading view initial position
- Fix animated image detection
- Fix divider color in AMOLED mode
- Fix crash when tapping title of "App theme" preference
- Fix reader action sheet not opening
- Fix shadow behind the Expand Info icon
- Fix crash caused by missing line in #5794
- Fix reader crash on Android 9
- Fix toolbar text color in light blue theme
- Fix blue background under action mode text selection handlers in blue theme
- Fix start/resume fab showing up when entering and then exiting action mode
- Fix today still being displayed even though relative time is off
- Fix library icon unchecked state
- Fix global search menu item title
- Fix selector in search card item

### Removed
- Remove the remaining MotionLayout
- Remove autoSizeText
- Remove explicit CardView dependency
- Remove ability to set in-app language differently from system's

## [0.12.1] - 2021-08-06

### Changed
- Release v0.12.1
- Revert "Use correct color for reader loading indicator "

## [0.12.0] - 2021-08-06

### Added
- Add functionality to open SettingsMainController when double-tapping the "more" button
- Add Dynamic theme for Android 12
- Add support for start/end fields for Kitsu
- Add link to Don't Kill My App! in advanced settings
- Add cover actions to a dialog when long-pressing manga cover
- Added "Tako" theme
- Support more image formats for covers
- Add warning for MIUI users when trying to restore backups with MIUI Optimization disabled
- Add Yin Yang Theme
- Add DARK_BLUE enum value back to avoid crash
- Add back android-process-button library
- Add favorited badge to browse and search
- Add start download now
- Add AlertDialog styles to Reader themes
- Added text to category changing dialog when shown with no categories
- Added "Yotsuba" theme
- Add background to draggable items
- Add back missing start/end margins in manga info header
- Add ripple to history items
- Add shortcut to tracking guide on website
- Address some build warnings
- Add behavior for modifying reader buttons depending on prev/next chapters
- Added category-wise display setting
- Add check for backstack size before pushing DownloadController
- Address some build warnings
- Support AVIF and HEIF images
- Add share and save cover actions
- Add AMOLED prefix to theme name
- Add long click to view manga in Migration Source Search
- Add better library item selectors
- Address some Kotlin language warnings

### Changed
- Release v0.12.0
- Weblate translations
- Use correct color for reader loading indicator
- Dependency updates
- Group advanced battery optimization setting entries
- Keep coroutine methods
- Change BottomNavigationView behavior
- Don't hide menu when scrolling through with ReaderSeekBar
- Set exported flags on activities
- Disable Android system auto backup
- Update Coil
- Update for AS Arctic Fox
- Set indeterminate as default state
- use the actions built in ignore case
- update issue closer to close anime/aniyomi
- Use chooser intent for sharing saved pages
- Revert changes to last_update behavior from #5436
- Reword tracking update preference since it updates status too
- Relax MIUI backup/restore warning
- Apply default night mode earlier
- Auto hide reader menu when user starts reading again
- Group 'Source not installed' cases in library update error log
- Reader loading progress indicator changes
- For library update error log, group errors by error string, and then sort the resulting list by source
- Update AboutLibraries
- Revert jsDelivr CDN fallback
- Require Komga to be installed when attempting to setup tracker
- Warn on backup creation for MIUI users
- Put Komga tracker in separate group
- Update detection of disabled MIUI Optimization
- Weblate translations
- Make default tracking status depend if the user has read chapter or not
- Bump compileSdk to 31
- Make incognito bar use primary colors
- Don't show navigation overlay if tap navigation is disabled
- Replace material-dialogs usage with Material Components'
- Chop long titles in library update notification, fix incrementing when updating covers
- Update to Kotlin 1.5.21
- Update Libary update notification.
- Hide the reader seekbar for single-page chapters
- Update request_feature.yml
- Update jsoup and Coil
- Hide Start/Resume FAB unless there are unread chapters and during loading
- Tweak chip contrast
- Optimize the Green Apple theme variant
- Improve Green Apple color in Light theme
- Reword delete chapter settings
- Improving genre search started from the manga page of a popular manga
- Use jsDelivr as fallback when GitHub can't be reached for extensions list
- Use fade transactions when handling shortcuts
- Parallel cover update job
- Update dependencies
- Show correct number of items in the library tit...
- Show all currently updating manga in library update notification
- Parallel library update
- Update dependencies
- Sanitize manga title in page download subfolder name
- Make Automatic Reader Theme pick background/text color based on dark mode preference
- Simplify locale override
- Update image decoder to add JPEG XL support
- Only update in-library manga chapter settings instead of all
- Sanitize spaces when setting URLs without domain
- Resource cleanup post-theme removal
- Update dependencies; remove unused android-process-button library
- Rename "Dark Blue" theme to "Blue"
- Set root project name, remove jcenter for plugin resolution
- Revert accidentally committed stuff (oops)
- Update to Conductor 3.0.0
- Track search dialog adjustments
- Sort Installed, Update, Untrusted Extenion by Name in Extensions Tab
- Use current locale when sorting library "alphabetically"
- Update dependencies
- Update delete history icon
- Merge light and dark themes
- Imported implementation for updating library by next expected update from Neko
- Change wording for "Per-category display setting"
- Create parity with extension repo issues
- Tracking sheet and search adjustments
- Extend library search by adding -<source> option
- Reader fixes after #5450
- Sort per category
- Match ReaderActivity theme with the rest of the app
- Update issue closer rules
- Update issue-moderator-action to v1.1
- Convert issue templates to the new issue forms
- Update image decoder with better AVIF support
- [SKIP CI] fix GithubUpdateChecker url
- More themes cleanup
- Move "Delete sweep" out from overflow
- Downgrade WorkManager
- Surface exceptions when fetching pages properly
- Improvements to the new library item selectors
- Revert "Set background job expedited policies"
- Enable secure screen when incognito mode is enabled
- Show global update error notifications by default
- Draw tablet manga info column under navbar
- Caching adjustments
- Get appropriate download link based on CPU ABI
- Use coroutine job for fetching next source page
- Don't expand source filter sheet on show
- Use smallest width instead of width for alt layouts
- Set orientation icon correctly when opening reader
- Handle HEIF images (partly addresses #4756)
- Make cover bigger on tablet UI
- Legacy backup conversion to Kotlin Serialization
- Update tablet UI
- Allow center aligned side nav icons
- Set background job expedited policies
- Update dependencies
- Run formatter
- Tap to enlarge cover
- Consolidate some of the app update classes
- Only show automatically refresh trackers setting if logged in to some trackers
- Generate APKs per CPU architecture
- Revert "Revert "Revert "Temporarily hide Komga tracker"""

### Fixed
- Fix RTL support
- Fix weird behaviour in library when switching display mode
- Fix forced secure screen disabled after disabling incognito
- Fix wonky webtoon layout when image is loaded at the top of the screen
- Fix reader activity not using preferred language
- Fix webtoon page takes up entire screen even if it's smaller
- Fix regression in cover fetching
- Fix list scrolling on quad-state dialog
- Fix incorrect saved tracker dates
- Fix light navigation bar not applied on first launch
- Fix transparent system bars after MainActivity recreated
- Fix Cover sharing and saving
- Fix splash screen icon on Android 12
- Fix yin & yang theme
- Fix incognito mode disabled after URL intent launched
- Fix Incognito Mode toggle not updating after disabled via notification
- Fix chapter source order not working correctly and allow refresh to update source order
- Fix category selected state
- Fix some views being click-through-able
- Fix link to List of Extensions
- Fix reader toolbar alpha applied to other components outside its activity
- Fix issues on older API versions and tablets
- Fix crash when opening the MangaController from...
- Fix incorrect toolbar text color after theme change
- Fix black  icon for small notifications on EMUI
- Fix library settings sheet causing app to crash...
- Fix download status not updated properly after starting batch download
- Fix crash on source page load error
- Fix gradient not being smooth
- Fix title jumping around when refreshing
- Fix image type build error

### Removed
- Remove janky tracker icon UI
- Remove autosizing for manga title in tablet view, fix centering
- Remove reader page number inset margin
- Remove unnecessary MultiDex library
- Remove autoAddTrack preference
- Remove unnecessary DB calls when setting chapter flag defaults
- Remove Hot Pink theme
- Remove en-GB option since we don't actually localize different English locales
- Remove explicit SKIP CI workflow logic

## [0.11.1] - 2021-05-31

### Changed
- Release 0.11.1
- Revert "Revert "Temporarily hide Komga tracker""
- Revert "Temporarily hide Komga tracker"

### Fixed
- Fix missing Injekt method crash

## [0.11.0] - 2021-05-31

### Added
- Add animations for Bottom Navigation items
- Add link to official subreddit
- Added "Green Apple" theme
- Added "Strawberry Daiquiri" theme
- Add "Midnight Dusk" and "Hot Pink" themes
- Add Komga as an unattended track service
- Add icons for links in the About section
- Add option to hide "Updates" and "History" buttons
- Add cancel all for series in download queue
- Add automatic setting to reader settings
- Add manga-wised rotation mode settings

### Changed
- Release 0.11.0
- Temporarily hide Komga tracker
- Update some icons
- Weblate translations
- Use existing vector icon for splash screen
- Show toast when toggling crop borders
- [SKIP CI] Add issue moderator action
- Run formatter on some resources
- Update AboutLibraries
- Try to avoid some Webview-related crashes
- Adjust chapter download button visual
- More bottom sheet improvements
- Update GMS plugin
- Update Kotlin and kotlinter
- Dependency updates
- Update ACRA
- Allow themes to style more objects
- Implement feature to hide "Local" badge from library manga
- Display the currently active restrictions in the library update preference
- Update dependencies
- Set grey setting sheet for Grey background option
- Display animated webp whenever possible, otherwise fallback to static image. Fixes #5139
- Hide the score display on the tracksheet if not supported
- Background tracker update during Library update
- Use 1.x source-api artifact from Maven Central
- Refactor TrackService.kt to remove unused `add` function
- Put shortcut to backup menu in More
- Use Title Case for theme names
- Make some strings in LocalSource translatable
- Handle toolbar title in manga details on tablets similar to on phones
- Fix scrollable pages
- Tweak tablet manga info column width
- Organize some classes
- Pull the rate limit interceptors from the extensions repo
- Update AGP and AboutLibraries
- Option to move nav rail buttons to bottom of screen
- Revert "Prevent view from being removed if a to is found  "
- Create a toolbar variable for ripples
- Hide irrelevant settings on tablets
- Update Discord logo asset
- Tablet manga view
- Use same chapter sorting logic in manga and reader views
- Update reader chapter list filtering to handle not downloaded/bookmarked
- Prevent view from being removed if a to is found
- Update ripples for tablet NavigationRail
- Ripples patch
- Fallback to default viewer properly
- Enforce same height for about links
- Change tab ripple color
- Shrink Komga logo asset
- More Proguard fixes for extensions
- Weblate translations
- Bump compileSdk to 30
- Reinstate Proguard/R8
- Disable swiping on switch in SwitchSettingsPreference
- Rename some biometrics things since it's no longer specifically for biometric auth
- Run formatter on drawables and layouts
- Ripple overhaul
- Try to avoid crashing when source fails to return pages
- Adjust tablet layout
- Tweak About view, make links actually clickable
- Collapse about links into a single row
- Refactor BaseBottomSheetDialog to set maxWidth with newer API
- [SKIP CI] Update issue-closer-action
- Increase padding to progress bar
- Change ordering of labels in "when" clause
- Restore original preference background after highlight animation
- Revert hide updates/history
- Library update notif text progress
- Avoid invalid reading mode/orientation selections
- Cleanup hide updates/history button settings
- Don't hide side nav when opening ActionToolbar on tablets
- Update OneWayFadeChangeHandler to match TachiyomiSY
- Initial tablet NavigationRailView implementation
- Minor cleanup
- Update dependencies
- Open migrated/copied MangaController right away
- Instantiate extension preferences with proper datastore earlier
- Don't toggle favorite status from snackbar if already added
- Automatic background color for PagerViewer
- Update Coil
- Update AGP for Android Studio 4.2
- Show notification to disable Incognito Mode when it's enabled
- Reader grayscale filter
- [SKIP CI] Update issue-closer-action
- Cancel scope in SettingsControllers properly
- Update kotlinx.serialization
- Change string chop method default to use smaller ... instead
- Re-enable update check job for Android M
- Better handling of coroutine cancellations for http calls
- Use Coil
- Update sqlite-android
- Lint fixes
- Move save pages to manga title setting to Reader section
- Creates folders according to manga title
- Use adaptive icon for app shortcuts
- Drop support for Android 5.x

### Fixed
- Fix last library category not being saved
- Fix toolbar menu being broken on transition
- Fix double free when when parsing webp images
- Fix GIF detection on previous commit
- Fix incognito mode disabled after the app kicked out of memory
- Fix reader chapter sort ordering
- Fix resume button not considering filters
- Fix some RecyclerView heights
- Fix action toolbar positioning
- Fix vector from being rasterized during build
- Fix Proguard rules for kotlinx.serialization (e.g. for MangaPlus)
- Fixed tracker sheet corner radius not being rounded on start
- Fix top padding in up Updates/History
- Fix decoder crash with 1px images and crop borders
- Fix grid columns on tablets, split out common main_activity layout sections
- Fix MultiSelectListPreference crash in extensions
- Fix rotation shortcut tooltip
- Fix source filter FAB disappear on rotation
- Fix settings search crash
- Fix navigation issue when activity is recreated
- Fix bugs in dual-page split
- Fix reference to removed V23 theme

### Removed
- Remove more unused strings
- Remove unused strings
- Remove kapt
- Remove unused Gson singleton factory
- Remove top margin of PreferenceCategory if no title set
- Remove unnecessary fillType attrs from app icons
- Remove 1 or 2 hour library updates to avoid DDoSing sources
- Remove material-design-dimens
- Remove legacy backup creation

## [0.10.12] - 2021-04-27

### Added
- Add link to official Facebook page

### Changed
- Release 0.10.12
- Weblate translations
- [SKIP CI] Update issue-closer-action
- Cleanup dual page split
- Minor cleanup to updating download status in Updates
- Don't automatically go to HALF_EXPANDED state for color filter tab
- Reset Incognito Mode on app relaunch
- Make the download progress status smoother
- Use popup menus for reader shortcuts instead of toggling through
- Maybe better handle MAL token expiration
- Downgrade back to stable OkHttp
- Make manga and chapter folder name searching case insensitive
- Sanitize source download folder name
- Show bottom nav when the tab page is changed
- Consider sort direction when downloading next n chapters
- Consider sort direction when resuming
- [SKIP CI] Update issue templates

### Fixed
- Fix download error icon color tint

### Removed
- Remove app update check on Android 5.x
- Remove "Locked" orientation, replace with explicit orientations
- Remove preview release notes

## [0.10.11] - 2021-04-19

### Added
- Add clipboard error string
- Add checkmark beside selected popup menu item
- Add navigation bar scrim
- Add navigation bar scrim

### Changed
- Release 0.10.11
- Weblate translations
- Theme BiometricUnlockActivity to avoid flashing light theme
- Include extension loading errors in error logs
- [SKIP CI] Update FUNDING.yml
- Update LeakCanary
- Clean up controller viewbinding creation
- Clean up ChapterCache (remove Gson, Rx usage)
- Themes cleanup
- Update KotlinX dependencies
- Minor cleanup
- Move reading mode toast to default bottom position
- [SKIP CI] Update README banner image
- Adjust ActionToolbar positioning
- Avoid duplicate actions in update notifications
- Avoid crash when users copying to clipboard fails because they have apps that are listening to their clipboards but also denied permissions
- Avoid rare crash in WebViewActivity
- [SKIP CI] Add string for EOL update check message
- Follow chapter sort setting for start/resume FAB
- Double tap Updates to go to Download Queue
- Use DSL for creating chapter description spanned string
- Follow chapter sort setting when downloading next n chapters
- Update issue templates
- Adjust MoreController bottom padding for navbar
- Long press reader settings icon to open color filter tab
- Case insensitive source directory search
- Adjust ActionToolbar positioning
- Minor cleanup
- Avoid crash when unknown reading mode is used
- Handle reader toolbar subtitle getting cut off when text is too big
- Include chapter fetch date when migrating
- Edge-to-edge in licenses activity
- Use accent color for edge effect
- Allow weaker unlock methods in Android 6 - 10
- Include debug info in dumped crash logs
- Allow dismissing download progress notification when paused
- Disallow forced dark mode, such as MIUI's
- Fully expand source filter sheet on show
- Use same non-sticky heading style as Browse for Updates/History
- Start download when tapping update notification
- Offset appbar using margin instead (maybe fixes #4819)
- Insets fix for migration manga list
- Always create releases as draft

### Fixed
- Fix activity leak
- Fix status bar icon colors in webview activity
- Fix chapter read status not being migrated
- Fix source SearchView stuck open until query submitted
- Fix webtoon mode not calling OnPageSelected in some cases (in upstream too)
- Fix toolbar elevation in History and Updates
- Fix ActionToolbar bottom offset
- Fix LibraryUpdateServiceTest so ./gradlew ... doesn't crash

### Removed
- Remove toolbar snapping

## [0.10.10] - 2021-04-11

### Added
- Add locales: jv, lt, ne
- Add Google DoH provider
- Add clarification for category exclusion
- Add sort by date fetched in library
- Add QuadStateCheckBox view
- Add tooltips for previous/next chapter buttons
- Add icon for crop border shortcut off state
- Add crop borders shortcut
- Add onPause\onResume persistence to searchView. Fixes issue #3627
- Add tooltips to bottom reader menu items
- Added Start/Finished Date Support to AniList
- Add navigation layout overlay
- Add icons for reading mode toggle
- Library update freq: add 4 & 8 hours
- Add reading mode toggle
- Add "my" locale
- Support CMYK and YCCK JPEGs and fix bad PNG cropping
- Add Right and Left to reader settings
- Add Twitter link to About section
- Add orientation toggle to bottom reader menu

### Changed
- Revert case insensitive source folder check
- Lint fixes/ignore some errors
- Release 0.10.10
- Make library update/backup error log action clearer for non-technical users
- Update DoH translations
- Weblate translations
- Actually ignore the case...
- Make source download folder name case-insensitive
- Log "Invalid download location" issues to error log
- Fix navigation bar insets not properly applied
- Move deletion actions to the IO thread
- Update some dependencies; downgrade core-ktx
- Revert manga title folder for saved pages
- Update to Gradle 7
- Draw edge-to-edge
- [SKIP CI] Add lock workflow
- Update some internal dependencies
- Search in library include manga description
- Update NDK, more KTX usage
- Minor cleanup
- Flip crop borders and orientation toggles
- Update Kotlin and Kotlinter
- Make reader spinner colors a bit more consistent
- Align filter spinners
- Revert using fetch date for updates list
- Allow excluding categories from auto-download
- Allow excluding categories from library update
- Use Material Dialogs for auto-download categories preference
- Use Material Dialogs for global update categories preference
- Move BiometricUtil to correct package
- Allow weaker unlock methods
- Use app name for page download folder and use manga title subfolders
- Make extension load error logs less verbose
- Minor cleanup
- Replace reading mode snackbar with toast
- Don't repeatedly vibrate/make sounds on download progress
- Revert "Drop support for Android 5.x"
- Better handle webtoon SSIV crop border change
- Drop support for Android 5.x
- Recreate webtoon SSIV when crop borders setting changes
- Allow translating DNS over HTTPS
- Use regular crop icon
- Clean up SpinnerPreference a bit
- Show nav overlay on invert tap change
- Prevent manga title from jumping
- Show number of manga per source in migrate menu
- Dismiss action toolbar after download action in updates
- Cleanup reader spinner layouts
- Clean up reader sheet spinner preferences
- Reduce height of sheet when on color filter tab
- Reorganize reader sheet contents a bit
- Split general and reading mode sheet settings
- Merge reader settings and color filter sheets
- Maybe make opening file picker for choosing backup file more reliable
- Use more common MIME type for protobuf
- Show unread entries first when sorting by unread
- Update plugins
- Handle null Anilist start dates
- Minor code cleanup
- Make tapping available extension row prompt install
- Update AGP
- Use newer action for build workflow
- Implement migration for source search
- Limit query for recent chapters to 500
- [SKIP CI] Update README.md
- [SKIP CI] Add Code of Conduct
- Less janky enum iteration
- Use fetch date instead of upload date when querying recent chapters
- Flip order of previous chapter reader transition text
- Round snackbar corners
- Adjust reader navigation button ripples
- Refactor LibraryUpdateService a bit for future changes
- Use Material dialogs for preferences
- Tweak dialog corner radius
- Move reader setting related classes
- Move clear history from advanced settings to history screen menu
- Weblate translations
- Disable sensor when using force orientation
- Allow scrolling within reader color filter sheet
- Update URL for Local Manga guide
- Dependency updates
- Revert to core-ktx:1.5.0-beta01
- [SKIP CI] Automatically reopen issues when valid
- Avoid crash during migration
- Hide subtitle in migration list of sources if no language set (i.e. uninstalled source)
- Use correct background for left chapter button in reader
- AndroidX dependency updates
- Dual page split allow to have different setting for Paged and Webtoon
- Let users invert dual page split
- Reword bookmark strings to clarify it's for a chapter, not a page
- Adjust reader seekbar design
- [SKIP CI] Add instructions on how to get crash logs in issue templates
- Initial adoption of bottom reader menus from TachiyomiSY
- Rename drawable with more consistent naming
- Allow clicking the toolbar to go to the manga
- Avoid crash when source list is animating
- Avoid rare crashes in settings search for ListPreferences
- Avoid crash when device fails to handle opening a URL
- Avoid crash if activity is already dead
- [SKIP CI] Update to issue-closer-action@v2.0
- Switch back to new image decoder for preview builds

### Fixed
- Fix global update category exclusion
- Fix label overflow for reader spinner preferences
- Fix nav overlay always showing on start
- Fix binding of intarray preferences (maybe fixes #4728)
- Fix Some Bangumi Track Bug
- Fix fullscreen not applying on opening reader
- Fix migration due to variable shadowing
- Fix chapters list getting updated from wrong thread
- Fix Bangumi search null image errors
- Fix offline restore ignoring manga from not installed sources
- Fix a decoder crash with RAR files
- Fix a decoder crash

### Removed
- Remove weird cropping from icon when showing missing chapter warning
- Remove insert page when dual page split get turned off
- Remove ALPHA from dual page split label
- Remove __cfduid cookie check
- Remove online protobuf backup restore option

## [0.10.9] - 2021-02-12

### Added
- Added dual page split setting
- Add weekly to library update frequency options
- Add action to directly share crash log file from notification
- Add Esperanto locale
- Add Right and Left navigation

### Changed
- Release 0.10.9
- Require minimum WebView v88, try to catch fatal errors too
- Minor download icon optimizations
- Make backup restoring logic more sequential
- Weblate translations
- Handle link for multisource extension commits
- Adjust some scopes
- Clean up LibraryUpdateService a bit
- Open manga when clicking thumbnail in migration list
- Show locales in list of sources to migrate
- Update AboutLibraries
- Revert attempt to programmatically determine user agent string; fallback to Edge
- Chapter backup optimization
- Massage user agent string from WebView a bit more
- Don't restrict filter sheet height anymore
- Avoid some unnecessary re-renderings of download icons
- Show help action when source fails to load
- Use AndroidX version of ContextThemeWrapper
- Do a regular return to cancel update jobs instead of throwing an exception
- Set clip data when sharing content URIs
- Minor optimizations for restoring full backups
- Switch back to new image decoder for preview builds

### Fixed
- Fix invisible overflow icon in chapter filter sheet in light blue theme
- Fix legacy backups
- Fix selected tab in sheets not being the accent color
- Fix downloads getting deleted when marked as unread

### Removed
- Remove ExperimentalSerializationApi opt-in annotations
- Remove unnecessary LayoutContainer implementations
- Remove some logic around old legacy backup versions + minor optimizations

## [0.10.8] - 2021-02-06

### Added
- Add manga count to the library header
- Add comments to not translate the word "WebView"
- Address unit test compilation errors
- Add sort by chapter number in download queue
- Add source name in download queue
- Add QUERY_ALL_PACKAGES permission (maybe fixes #4313)
- Add method for users to save error logs to a file
- Add shortcut to see commit history for official extensions
- Add filter for tracking
- Add list of things to change in forks to CONTRIBUTING.md
- Address coroutine scope leaks in custom views
- Address more coroutine scope leaks
- Add way to search by list items' titles
- Add more padding to download buttons
- Add date Format
- Add ID search workaround for MAL tracking
- Add Telugu to language setting
- Add error state to chapter download icons
- Add forced MAL logout for next release migration

### Changed
- Release 0.10.8
- Avoid crash when changing spinner indeterminate state
- Update dependencies
- Update to Gradle 6.8.2
- Don't automatically set MAL start date
- Rounded bottom sheets
- Pad trackers list a bit
- Weblate translations
- Minor cleanup
- Move tracking to a bottom sheet
- Regenerate drawables
- Handle failures when updating metadata in library updater
- Apply bottom sheet dialog with restriction consistently
- Update AndroidX dependencies
- Unify history and update item
- Ignore failures when updating metadata as part of library update
- Disable Acra crash logs in dev builds
- Update Okio, use more KTX stuff
- Update total number of chapters when refreshing MAL entries
- Parse correct object when finding existing MAL list item
- Refactor tracker name strings
- Extend track filter
- Weblate translations
- Minor cleanup
- Perform metadata update in global scope
- Revert async metadata updates to fix lag when updating
- Point to preview release for what's new
- Update AboutLibraries plugin
- Extract user agent string from WebView
- Update trackers in parallel, update manga metadata asynchronously
- Minor dependency updates
- Reword download chapter number sorting options
- Ignore error when cover is missing in Kitsu search results
- Surface tracking search errors properly
- Don't stop downloader after deleting downloads if it wasn't running
- Match color for download, header, and pin buttons
- Use proper method to clear notification actions
- Update AGP for Android Studio 4.1.2
- Delay restoring AppBar elevation on Android 5.0
- Hide tracking when no tracker is logged in and change filter logic
- More consistent injectLazy style
- [SKIP CI] Update fork change checklist
- Move CONTRIBUTING.md to top level
- Move ACRA endpoint config to build.gradle.kts
- Reimplement MAL start/end date support
- Revert removal of tracker start/end date
- Handle download cancelation from icon properly
- Update Material Components
- Simplify lookup for existing MAL list item
- Update AndroidX dependencies
- Show error when trying to download chapters from not installed source
- Update SubsamplingScaleImageView
- More coroutine tweaks
- Avoid using global scope where appropriate
- Use lifecycleScope directly
- Revert "Use flows instead of relays for extensions loading"
- Minor fixes regarding leaks
- Switch to version of SubsamplingScaleImageView with new image decoder
- Allow typing in tracker score similar to chapters
- Revert bad RxJava conversion that prevented tracking data to be updated in UI
- Reword unmetered network restriction for library updates
- Use JDK 11 for build workflow
- Surface "NSFW" (includes things like ecchi) results in MAL search
- Refactor bridged RxJava/coroutine calls in SearchPresenters
- Refactor bridged RxJava/coroutine calls in MangaPresenter
- Refactor Kitsu API to remove Retrofit usage
- Use flows instead of relays for extensions loading
- More consistent wording for NSFW warning strings
- Fully remove usages of RxJava from tracker classes
- Adjust download icon alignment more
- Convert more TrackService methods to coroutines
- Change MAL ID search prefix to "id:"
- Use updated Tachiyomi version of DirectionalViewPager
- Tint downloaded icons with primary color
- Hide scrollbar from compact tags group
- Adjust padding of text before download icons
- Note valid backup file extensions in error toast
- Replace global search context menu option with share target
- Minor cleanup
- Navigation settings and split invert tapping for webtoon and pager
- Replace usages of fetchChapterList with 1.x getChapterList API
- Replace usages of fetchMangaDetails with 1.x getMangaDetails API
- Viewer navigation
- Direct user back to global search when coming from source search results
- Include source name in backup restore error logs
- Implement click events for chapter download icons
- Use coroutines instead of rx for some MangaPresenter operations
- Adjust chapters filter icon to line up with download icons
- Move some build.gradle.kts content around
- Only include Firebase dependency in standard flavor
- Convert app build.gradle to Kotlin DSL
- Handle last read page being above total page count
- Increase per-page limit when searching MAL manga list
- Update preview build links
- Minor cleanup of some tracker observables
- Find existing entry in MAL list when binding
- Adjust download icon sizing
- Tweak manga info header backdrop
- Refactor tracker response parsing
- Show download progress in download icons
- Animate download icon
- Weblate translations
- Use master branch for build workflow
- Minor cleanup of UpdatesHolder
- Hide chapter download icons for local manga
- Refactor response parsing helper function
- Refactor download states into enum
- Initial chapter download icon implementation
- Log exception on invalid download directory issue
- Replace circular ProgressBars with Material component
- Replace ProgressBars with Material component
- Update dependencies
- Try to avoid crashing when unable to get backup filename for some reason
- Reader snackbar dismissible
- Convert tracker add/update/login methods to coroutines
- Use coroutines for Bangumi and Shikimori APIs
- Use coroutines for Anilist API
- Migrate Kitsu API to coroutines and kotlinx.serialization
- Make OkHttp coroutine calls always throw exceptions on errors
- Surface MAL HTTP errors properly
- Filter out novels from MAL search results
- Format MAL search result status/type better
- Bump versionCode so next build will force MAL logout
- Update NDK & buildTools, fix deprecated Parcelize
- [SKIP CI] Add preview note for MAL rewrite
- Strip out no longer used tracker start/end date code
- Migrate to official MyAnimeList API
- Don't surface hidden settings when searching
- Update app repo URL
- Update extensions repo URL
- Apply theme to OAuth login redirect activities
- Misc tracker code cleanup
- Refactor CustomTabsIntent creation

### Fixed
- Fix unreadable sheet tab text in light blue theme
- Fix cancelling library updates not working
- Fix multi-select phantom anchor bug in manga chapters and library
- Fix Kitsu toasting "Logged in" when there is an error
- Fix display mode not updating in source view
- Fix jpeg decoder when used with high samples
- Fix png artifacts & banding when ratio > 1
- Fix bad cropping of PNGs with alpha channel
- Fix navigation from feedback
- Fix crash when no chapters can't be loaded
- Fix a crash with the new decoder when cropping borders of an entirely white or black image
- Fixes on the new decoder library
- Fix content focusiblity issues when using remote/controllers
- Fix malformed extension URLs
- Fix download progress bar sizing to match icons
- Fix crash on updating trackers after reading with no network
- Fix trackers after MAL not updating

### Removed
- Remove buildSrc module's dependency on JCenter
- Remove strings that shouldn't have been translated
- Remove unused dimen values
- Remove some unused rx/coroutine bridge code
- Remove usage of RxJava from LibraryUpdateService
- Remove unused RECEIVE_BOOT_COMPLETED permission
- Remove duplicated info from CONTRIBUTING.md
- Remove usage of RxJava from backup/restore
- Remove use of RxJava from TrackPresenter
- Remove some OptIn annotations
- Remove some unnecessary coroutine dispatcher switching
- Remove some unused variables
- Remove usage of Retrofit for update check and extensions list
- Remove unnecessary BaseWebViewActivity class
- Remove usage of Gson in Kitsu tracker
- Remove License Appendix That Should Have Been Removed Initially

## [0.10.7] - 2020-12-14

### Changed
- Release 0.10.7
- Minor code cleanup
- Complete migration off of Kotlin synthetics
- Show MAL relogin message on update, localize error message
- Use view binding for date headers
- Update to coroutines 1.4.2
- Reword NSFW settings section
- More crash fixes
- Require WebView 86+
- Some crash fixes
- Suppress some deprecation warnings
- Disable release postprocessing (Proguard)
- Note that toggling NSFW sources requires a restart
- Break out NSFW hiding/labeling into separate settings
- Flip left/right key events for Webtoon viewer
- Revert "Hide incomplete NSFW source labelling settings"
- [SKIP CI] Update issue templates

### Fixed
- Fix loading fallback thumbnails in browse view

### Removed
- Remove bundled fallback file picker
- Remove source overwrite logic since built-in sources no longer exist

## [0.10.6] - 2020-12-12

### Added
- Add text selection shortcut to invoke global search
- Add Galician locale
- Add global search progress bar
- Add help shortcut for source migration
- Add support for S Pen actions
- Add workflow steps for creating releases
- Add 1.x page model converters
- Add Uzbek locale
- Add Proguard rules for kotlinx.serialization
- Add Amharic locale
- Add banner for Incognito Mode
- Add infinite history and search history
- Add option to hide bottom bar when scrolling
- Add ability to choose what to remove for selected mangas
- Adding more UI polish, add comments for future enhancements.
- Add search button to MoreController, stop infinite recursion.
- Adding class stubs for settings search, UI elements.
- Add sah locale

### Changed
- Release 0.10.6
- Hide incomplete NSFW source labelling settings
- Force MAL logout on update
- Update Gradle
- Weblate translations
- Revert "Distinguish between no results and loading when sorting global search results"
- Don't scroll to top when navigating back/forward in WebView
- Update to Kotlin 1.4.21 and kotlinter 3.3.0
- Use WebView auth flow for MAL
- Update libraries, some lints
- Update to Kotlin 1.4.20
- Use more up-to-date fork of junrar
- Update AndroidX and Material Components dependencies
- Weblate translations
- Use regular minified extensions JSON instead of explicitly handling gzip encoding
- Enhance incognito mode
- Tweak default dark theme colors
- Revert edge to edge
- Replace more Kotlin synthetics
- Replace more Kotlin synthetics
- Replace Kotlin synthetic views in viewholders
- Replace more usages of Kotlin synthetic views
- Move NSFW source setting into Browse settings
- Fall back to filename in backup creation notification if path not available
- Distinguish between no results and loading when sorting global search results
- More bottom inset padding fixes
- Use jcenter to get 1.x dependencies
- Handle bottom insets in FAB controllers too
- Further abstract how bottom navbar padding is applied
- Handle bottom navbar padding when drawing edge to edge
- Create extension function for applying system insets
- Use ViewCompat for setting MainActivity inset paddings
- More restore code cleanup, remove some SY-specific logic
- Update Firebase
- Set preview/experimental compiler flags instead of using annotations
- Pad bottom of MoreController so bottom nav doesn't overlap content
- Some more code cleanup
- Default automatic legacy backups to true for now
- Some more code cleanup
- Merge restore entry points, avoid unnecessary new strings
- Minor cleanup
- Make a protobuf based backup system
- Draw under navbar in Android 9+
- Update AGP for AS 4.1.1
- [SKIP CI] Use non-fork version of APK signing action
- Update dependencies
- Tweak manga info header
- Hide locale subtitle for local source
- Update to serialization 1.0.1 and coroutines 1.4.1
- Singleton instance of Json serializer
- Update dependencies
- Use 1.x API to fetch manga details in browse view
- Change list view font size back to 16sp
- Weblate translations
- Consume and extend 1.x Source API
- Replace language code in Global Search with secondary text
- Janky workaround for collapsed global search covers
- Minor dependency updates
- Update Global search layout to match Library and Browse
- Use default height for extended FAB
- Lower minWidth for extended FAB
- Show locale in sources list items
- Darken the description colors
- Use secondary color for manga info header action button default state
- Auto-formatting
- Update AGP for Android Studio 4.1
- Use some more KTX and Compat stuff
- Trust user-added CAs (closes https://github.com/inorichi/tachiyomi-extensions/issues/4581)
- Migrate to kotlinx.serialization for Bangumi
- Migrate to kotlinx.serialization for Shikimori
- Migrate to kotlinx.serialization for download store and deleter
- Migrate to kotlinx.serialization for Anilist
- Migrate to kotlinx.serialization for extensions and update fetching
- [SKIP CI] Remove dev build logic from Travis CI config
- [SKIP CI] Replace dead link in README with correct one
- Bump minimum WebView version to 84
- Update dependencies
- Update AboutLibraries
- History fixes
- Cancel previous CI workflow runs
- Use eskatos/gradle-command-action instead of manually handling caching
- Skip ci in commit message condition check
- Only run build check workflow for pushes to dev or master branches
- Translations (Continuous)
- Workflow improvements
- Prevent tag search if browsing from latest (sort of closes #3625)
- Update issue_closer.yml
- Set activated states for manga info favorite/tracker buttons
- Reorder chapter filters to better match library filters
- Ability to delete reading history
- Show downloaded only banner in all views
- Minor string cleanup for Incognito Mode
- [Feature Request] Option to turn off History - #3772
- Update AndroidX dependencies
- Update subsampling-scale-image-view
- Use tristate checkboxes for chapters list filters
- Clean up bottom nav bar scrolling behavior toggling
- Tweak navigation view group header style
- Color selected bottom nav item with accent color when theme isn't blue
- Use same padding as source icons for extensions
- Color selected tab with accent color when theme isn't blue
- Use background color for list view
- Shorten settings search package name
- Update Ben Manes versions lib
- Minor settings search code cleanup
- #3520 Searchable Settings
- Merge branch 'dev' into dev-settings-search
- Merge pull request #5 from lmj0011/dev-settings-search
- - retain search query when navigating *away* from SettingsSearchController
- Inlined non-reused key strings.
- Code review cleanup and refactoring.
- Merge pull request #4 from lmj0011/dev-settings-search
- - moved call to SettingsSearchHelper.initPreferenceSearchResultCollection() into SettingsSearchController
- Limiting search to settings menu only, localized breadcrumb string, and code cleanup after code review.
- Merge pull request #3 from lmj0011/dev-settings-search-highlighter
- - Ensure all Preferences have a key set or else the highlighting effect will have no effect on it.
- - implement prefernce highlighting after settings search
- Merge pull request #2 from lmj0011/dev-settings-search
- - initialize SearchResultCollection once in Activity.onCreate
- Set query hint, clean up code smell.
- Merge branch 'dev' into dev-settings-search
- Merge pull request #1 from lmj0011/dev-settings-search
- -  implement searchable settings
- Move manga info summary more/less button toggle
- Center reader transition text properly
- Update build status badge in README
- Perform build check on push, move Gradle wrapper validation into build action
- Minor updates
- Send manga/chapter/page details when sharing a chapter page
- Tri-state library filters
- Clean up global chapter settings code
- [feature] add ability to set global filter/sort/display for Manga chapters
- Start updating manga info view header design
- Revert "Hide parental controls section for release"

### Fixed
- Fix annotations package name
- Fix crash when a preference doesn't have a title (e.g. info preference)
- Fix keyboard sometimes affecting bottom inset padding
- Fix restore in Android 11
- Fix transparent navbar when bottom sheets are opened
- Fix manga info description scrim on Android 5
- Fix non-transparent navigation bar
- Fix Bangumi login
- Fix Bangumi API response deserialization
- Fix missing chapter warning when chapter number is not recognized
- Fix Shikimori login
- Fix deleting history not refreshing the view
- Fix visual issue with bottom padding in filters sheet
- Fix color filter sheet content alignment
- Fix chapter filter icon tinting
- Fix scrolled content being visible behind navigation view group
- Fix downloaded only filter

### Removed
- Remove 10 results per source limit from global search (still limited to 1 page)
- Remove "full_" from v3 backup default file names
- Remove TravisCI build config
- Remove a stray trailing dash
- Remove from queue after read
- Remove card backgrounds from browse lists
- Remove unneeded SettingsControllerFactory.
- Remove support for backup v1

## [0.10.5] - 2020-09-14

### Added
- Add spacing on top of sources/extensions/migrate lists
- Add missing chapter warning
- Add PR build check action

### Changed
- Release 0.10.5
- Hide parental controls section for release
- Translated using Weblate (Bulgarian)
- Use Kolinter Gradle plugin for linting instead of ktlint directly
- Check GitHub for preview release updates instead of inorichi's server
- Update preview build links in README
- Use background color for some lists
- Replace deprecated system window insets usage
- Update OkHttp and Conscrypt
- Update to Kotlin 1.4.10
- Always show missing chapter warning if there are missing chapters
- Refactor common chapter transition views into separate view
- Localize "No chapters found" error
- Change sources sort to case-insensitive
- Update Conscrypt
- Move share manga button to toolbar menu
- Update dependencies
- Adopt OneWayFadeChangeHandler from SY
- Filter out hidden directories for local source
- Adopt tab/controller transitions from SY
- Clean up X-Requested-With change
- Update WebViewActivity.kt
- Update ActionMode styling
- AndroidX dependency updates
- Don't enqueue bookmarked chapters for deletion
- Minor wording edit
- Use core-ktx for bolding chapter transition text
- Dependency updates
- Update to Kotlin 1.4
- Revert ktlint update, unrevert Gradle and PR build workflow reverts
- Update and clarify message on tracking services
- Automatic linting fixes
- Revert Gradle update
- Unhide parental controls settings
- Slight gradle cleanup, plugin updates
- Update gradle wrapper
- Optimize images using ezgif

### Fixed
- Fix Kotlinter name typo
- Fix Chinese plurals
- Fix text alignment in transition view when no more chapters available

### Removed
- Remove list dividers
- Remove unused string, fix improperly formatted Slovak string
- Remove OkHttp Proguard rules
- Remove Glide Proguard rules
- Remove broken PR build workflow for now

## [0.10.4] - 2020-08-10

### Added
- Add 18+ warnings in extensions list
- Add option to prevent deleting bookmarked chapters
- Add mark as read/unread to library

### Changed
- Release 0.10.4
- Update issue templates
- Split out NSFW source setting to separate section
- Translated using Weblate (Swedish)
- Lift toolbar on scroll in extension details and manga controllers
- Allow annotating SourceFactory with @Nsfw to block all sources within it
- Minor cleanup
- Minor rewording of chapter deletion settings
- Bubble up sources with results in global search
- Update OkHttp
- Swallow errors when trying to determine available disk space when downloading
- Allow partially loading extensions with individually marked NSFW sources
- Option to hide NSFW extensions
- Explicitly depend on core-ktx
- Dismiss add manga snackbar when leaving controller
- Warn before restoring backup if trackers aren't logged in
- Move tracker setting dialogs
- Minor cleanup
- Revert "Use insetter library for handling inset padding"

### Fixed
- Fix Chinese plural string
- Fix MAL 0/10 scores
- Fix toolbar being expanded when opening preference dialogs

## [0.10.3] - 2020-08-03

### Changed
- Release 0.10.3
- Use dialog to show what's new release info
- Adjust vertical reading mode tap zones
- Explicitly dismiss progress notification on downloader stop
- Use insetter library for handling inset padding
- Adjust download badge color again
- Request gzipped version of extensions repo
- Revert "Use AndroidX WebKit library"

### Fixed
- Fix snackbars not being in viewport properly
- Fix manga title disappearing in toolbar when pushing another controller

### Removed
- Remove Tagalog translations

## [0.10.2] - 2020-08-02

### Changed
- Release 0.10.2
- Make download badges lighter to improve contrast
- Translated using Weblate (Russian)
- Move download warnings/errors to separate notification channel
- Revert "Downgrade coroutines and flow-preferences"
- Don't show completed notification if download error notification was shown
- Filter out chapter entries with duplicate URLs

### Fixed
- Fix crash when filter groups contain items with identical names
- Fix downloads not working for custom SD card paths
- Fix history item icon tint in light blue theme
- Fix dividers in migrate list
- Fix last used source pinned status

## [0.10.1] - 2020-08-01

### Changed
- Release 0.10.1

### Fixed
- Fix for reader crash in < Android 9

## [0.10.0] - 2020-08-01

### Added
- Add pin icon to sources list
- Add operator functions for handling set preferences
- Add ripple to global search source title
- Add shortcut to global search query from library
- Add ability to sort library by date added
- Add cv and fil locales
- Add ability to download unread chapters from library
- Add option to reverse tapping
- Add option to reader sheet
- Add option to reverse tapping
- Add advanced option for DNS over HTTPS via Cloudflare
- Add network header logging in debug builds
- Add shortcut to open extension package in system settings
- Add tooltips to manga info header action icons
- Add Persian locale
- Add categories to more
- Add some missing locales
- Add arrow to source search headers
- Add FastScroller to downloads
- Add Browse to start screen options
- Add bottom padding to migrate sources list
- Add option to hide library category tabs
- Add explicit refresh icon asset (maybe fixes #3218)
- Add bottom padding to history/sources/extensions
- Added missing sorting cases handling
- Added sorting by upload date
- Add migrate option from manga info view
- Add fastscroller to migration lists
- Add fastscroller to updates and history
- Add Croatian to settings
- Add lost Croatian translation
- Add more info in tracking settings section

### Changed
- Release 0.10.0
- Translated using Weblate (French)
- Downgrade coroutines and flow-preferences
- Temporarily revert to stable version of androidx.biometric
- Temporarily unrevert crop borders unification
- Shift WebView checks to necessary places only to allow for basic usage
- Actually fix library search properly
- More core-ktx usages
- Use Kotlin extensions for preference editing
- Make source options dialog into a controller to retain state
- Hide cutout option when appropriate in reader settings sheet
- Update ConstraintLayout
- Split download notifications into progress and complete channels
- Replace VectorDrawableCompat.create() with AppCompatResources.getDrawable()
- [Feature Request] - Download Complete Remidner #3475
- Explicitly destroy webview on activity destroy
- Prevent spamming updates with newly favorited manga
- Show lang code in source long press dialog
- Don't show chapter number in history item when unknown
- Translated using Weblate (Croatian)
- Show message when searching with no pinned sources
- Minor optimizations for local source dir lookups
- Update dependencies
- Lazily find chapter directories
- Inline extension functions
- Increase dismiss timeout for what's new snackbar
- Use some more core-ktx extensions
- Replace custom visibility extension functions
- Hide manga title in toolbar when at top
- Update Material Components
- Change to J2k style downloads while keeping support for the old ones
- More consistent library list view padding
- Hide tracking button if none logged in, show for non-favorited manga
- Pad manga info tag chips properly to avoid overlapping scrollbar
- Update dependencies
- Revert ViewPager2 library
- Don't initialize mangas if viewing source in list view if on metered connection
- Migrate library to ViewPager2
- Rename chapters_controller to manga_controller
- Explicitly show "No results found" in global search instead of hiding row
- Revert "Make controllers responsible for showing/hiding FAB"
- Show tracker status in button
- Update subsampling-scale-image-view
- Switch to tachiyomiorg fork of subsampling-scale-image-view
- Manga about section layout tweaks
- Move chapter filter/sort/display settings into a sheet
- Toggle about section when tapping on header/empty space
- Long press favorite button to manage categories
- Make controllers responsible for showing/hiding FAB
- Tweak track search dialog list item paddings
- Update Android Gradle plugin for Android Studio 4.0.1
- Include source ID if name not found in restore error log
- Include source name in update error log
- Move edit categories to overflow
- Allow category names with different casing
- Enable more WebView settings to better mimic regular browser
- Don't capitalize buttons
- Replace some usages of findViewById
- Use view binding for sheets
- Speed up controller fade and tab expansion animations
- Move edit cover to manga info
- Hide migrate option for non-favorited manga
- Hide toolbars when reader color filter sheet is opened
- Reorder animation speed options
- Update some icons
- Use root FAB/CoordinatorLayout in MangaController
- Move tracking to manga info actions
- Group theme settings into category
- Split general reader settings into reading mode and display
- Make page transitions setting apply to webtoon viewer as well
- Unify crop borders settings
- Hide invert volume keys setting when volume keys isn't enabled
- Prevent downloads when less than 50MB of disk space is available
- Attach some FABs and snackbars to root CoordinatorLayout
- Don't capitalize category names
- Update build.gradle
- Update dependencies, remove play-services-oss-licenses
- Update some icons
- Make tabs not all caps
- Update BaseController.kt
- Use custom view to handle manga info cover size
- Point to GitHub releases for stable changelogs
- Move preview notes to GitHub
- Translated using Weblate (Chuvash)
- Merge pull request #3406 from purinsan/dev
- Move MaterialFastScroll to widget package
- Fallback to default UA string for all network requests
- Update notifier paused state when starting downloads
- Define SDK/build tool versions in buildSrc
- Dependency updates
- Dependency updates
- Hide download menu for local manga
- Jump to chapters list earlier on to avoid jank
- More descriptive "Unknown"s in manga info
- Hide option if tapping disabled
- Hide from reader sheet if tapping disabled and remove hard coded string
- Use enum instead of boolean
- Invert tapping for Webtoon and Vertical
- Resolve merge conflicts
- Make jumping to manga chapters optional
- Separate out chapters heading into separate adapter
- Scroll directly to chapters list for library manga
- Lazily instantiate Cloudflare client
- Open error log on tapping notification body
- Ignore fact that loader might be null
- Move about summary more/less expander button
- Replace filter group icons with expand more/less
- Scroll up/down when tapping top/bottom thirds in vertical reading modes
- Show available manga info on view load
- Restore separate artist field
- Allow switching between read/unread chapters more easily
- More manga info header tweaks
- Bleed cover backdrop into actions bar in manga info header
- Translated using Weblate (Turkish)
- Combine chapter sort asc/desc and sorting mode menus
- Merge manga info and chapters views
- Use view binding in TrackAdapter
- Allow extension details header to scroll
- Use download badge color for downloaded only banner
- Rename some code from "catalogue" to "source"
- Restore individual sources in source filter view
- Adopt download/local badge colors from J2K
- Stop IDE from complaining about missing translations
- Localize/reword "Loader not implemented" error message
- Chapter deletion logic fixed
- Clean up extension details layout a bit
- Group extension details classes together
- Georgian translation
- Translated using Weblate (Portuguese (Brazil))
- Move untrusted/obsolete/unofficial extension text
- Show "Start" in chapters FAB if nothing is read yet
- Rounded library badges
- Combine author and artist fields in manga info
- Update some themes
- Reduce navigation view text weight
- Bump dependencies
- Hide download/delete chapter menu item for local manga
- Bump AndroidX dependency versions
- Update SwipeRefreshLayout
- Use AndroidX WebKit library
- Enable localStorage in WebView
- Switch to AboutLibraries
- Maybe fix license task for Windows
- TLS 1.3 support for Android < 10
- Use Gradle with sources
- Reading mode snackbar
- Make extension settings button inline
- Update conductor-support-preference to handle EditTextPreference bind listener
- Alternate open source licenses plugin
- Update source/extension filter controller titles
- Move source preferences to separate controller
- Global Search click title to search in Source
- Update Gradle
- Default reading mode to RTL (since this is a manga app...)
- Use material password toggle
- Tweak extension detail header design
- Replace some icons
- Manage sources from extension details
- Sort sources/extensions filter languages
- Mark isDownloading flag as volatile (maybe fixes #3219)
- Localize "Page list is empty" exception message
- Force proper LTR layout for reader pages/bottom toolbar
- Reword theme settings
- Minor cleanup, remove some usages of ArrayList
- Replace deprecated height/width constraint attributes
- Set reader menu visibility on system UI visibility change (closes #3149 and #2068)
- Use onBackpressureLatest for chapter/page download observables (maybe fixes #3229)
- Bump Firebase dependency
- Handle default category and add favorite check
- Update Android Gradle plugin for AS 4.0
- Use getEnum for theme preferences too
- Use actual enum support for display mode preferences
- Use enums for other PreferenceValues
- Comfortable grid code cleanup
- Comfortable Grid
- Convert source display mode preference to flow, remove RxPreferences
- Convert column preferences to flows
- Convert last used source preference to flow
- [CI SKIP] Update issue closer action
- Split up MigrationController
- Reorganize some migration classes
- Move migration into browse as a tab
- Move migration classes under browse
- Update some icons
- Handle empty thumbnail_url when refreshing covers
- Tweak history card design
- Avoid replacing covers with null when updating library (sort of closes #3194)
- Group advanced settings
- Make metadata updating optional
- Move categories up in library settings
- Update drag icon
- Dependency updates
- Rename downloaded chapters
- Change resume button in history to an icon
- Refactor history_item.xml to use ConstraintLayout
- Scroll up/down when tapping top/bottom quarters of webtoon viewer
- Make library update error notification optional
- Download new chapters changes
- Sort chapters by upload date
- Implemented review changes
- Minor edits
- Square covers in list view
- Move cover card outline clipping code from item to holder classes
- Specify charset for ZIP chapters when using Android N+
- Sort list of sources in migration alphabetically
- Localize tracker not logged in error
- Warn about missing sources before restoring backup
- Minor cleanup
- Return job failure if library update actually doesn't start
- Slightly simplify AMOLED theme definition
- Minor show more info button margin adjustment
- Translations (Continuous)
- Move extension preferences to separate controller
- Better distinguish between obsolete and unofficial extensions
- Show notification with error log on update failures
- Reword "Pager" to "Paged"
- Avoid showing uninstalled source as last used
- Null check for local source cover parent dir
- Using a float on the progress on app updates
- Don't throw exception to stop restore job
- Copy to clipboard when long pressing tracking title
- Temporarily revert concurrent manga updates
- Merge branch 'dev' of github.com:inorichi/tachiyomi into dev
- Cover Update Followup to Address #3139
- Move notification logic out of LibraryUpdateService
- Minor edits
- Animate in/out ActionToolbar
- Show date format examples, migrate to FlowPreferences
- Convert rotation to FlowPreference, remove some unused subscriptions code
- Default unreadBadge setting to true
- Minor wording edits
- Manga cover updates
- Update details metadata along with chapters list
- Move DB transaction blocks to only the DB portions of restore logic
- Revert Nucleus to 3.0.0
- Option to hide unread badges
- String Formatting Fixes
- Concurrently refresh trackers
- Do library checks from up to 5 sources concurrently
- Download from up to 5 different sources concurrently
- Concurrently download up to 5 pages at a time
- Replace restore completion string with plurals
- Translated using Weblate (Swedish)
- Translated using Weblate (Swedish)
- Show icon when chapter is bookmarked
- MaterialFastScroll updates
- Use borderless buttons everywhere for consistency
- Do some download deletion in coroutines instead of completable
- Minor cleanup of wakelocks, extension ID backup
- Destroy action mode after actioning in chapters list
- Adopt MaterialFastScroll from J2K fork
- Increase webtoon setting change page refresh range
- Alternative way of reading local manga JSON file
- Tweak about manga heading
- Convert app updater to foreground service
- Refresh page on 32-bit color setting change
- Update changelog link for preview builds
- Lighter weight method of rounding cover art
- [CI SKIP] Add dev branch deploy script configuration
- Only alert once for backup/restore progress notifications
- Bunch of crash fixes
- More extreme method for enforcing WebView availability
- Update issue templates

### Fixed
- Fix tap region for manga summary
- Fix library search query being lost when returning
- Fix download status updates not appearing in chapters list
- Fix getting stuck in chapter loop when chapters have identical URLs
- Fix source item flashing when pinning
- Fix Chinese plurals
- Fix weird backstack behaviour after clearing database
- Download on WiFi regardless of metered status
- Fix manga overflow menu items not appearing after adding to library via categories
- Fix checked state for manga header buttons
- Fix manga info actions being cut off
- Fix download cache not working for a source name change
- Fix Chinese plurals
- Fix Set categories dialog not showing up when manga is added from download snackbar
- Fix a settings section label
- Fix string for preference key
- Fix about info now showing after initial manga load
- Fix filter group icon being invisible in light theme
- Fix webview height issue
- Fix crash when opening chapter from migration
- Fix being unable to restore backups if there's no categories
- Fix recycled icon in source migration list when source isn't installed
- Fix cover thumbnails not being translucent for favorited manga in sources
- Fix unread badges not hiding in list view
- Fix Chinese plurals
- Fix regular font family name
- Fix updates/history section headers in RTL locales
- Fix bottom nav opening if opening manga from updates while in action mode
- Fix anilist jsonnull issue

### Removed
- Remove explicit source browse button, tint pin icon when pinned
- Remove divider between manga info header and chapters header
- Remove unused ViewStatePagerAdapter dependency
- Remove redundant Reading Mode header
- Remove unused CoverCache param from LibraryController
- Remove redundant layout for reader color filter sheet
- Remove color filter preview image
- Remove 32-bit color setting from reader sheet
- Remove "No chapter" string in favour of just "0 chapters" (should close #3357)
- Remove redundant landscape manga info header
- Remove incorrectly translated app name
- Remove some unnecessary strings
- Remove categories for multi language "single" sources
- Remove unused INSTALL_SHORTCUT permission
- Remove unused arrays
- Remove hide option from local source
- Remove Serializable interface from Source
- Remove explicit "SELECT" button from migration source list
- Remove redundant helper function
- Remove unused function
- Remove redundant DB call in library settings
- Remove fdroid flavor

## [0.9.2] - 2020-05-02

### Added
- Add link to extensions repo

### Changed
- Release 0.9.2
- More ActionToolbar tweaks
- Force FastScrollers to be on right even in RTL
- Translated using Weblate (Malay)
- Swap bottom nav and ActionToolbar when appropriate
- Revert last_updated change
- Hide app/nav bars on scroll
- Revert to old sorting library
- Show number of categories in setting summary
- Separate out series viewer setting to its own group in reader sheet
- Move pager-specific settings into proper category, add summary for 32-bit color setting
- Show 32-bit color setting in reader sheet
- Hide filter FAB when opened

### Fixed
- Fix backup failing when source isn't installed

## [0.9.1] - 2020-05-02

### Added
- Add gray reader background option

### Changed
- Release 0.9.1
- Start storing extension ID/source name mapping in backup files
- Reset sort on update if using old sort by source setting
- Move queue start/pause to FAB
- Attempt to remove sound from backup/restore completion notifications
- Reword title display mode
- Relay extension changes to sources controller
- Disable Proguard
- Update issue templates

### Fixed
- Fix manga info being cut off
- Fix chapter list selection uninverting
- Fix preload never being restricted

### Removed
- Remove confirmation prompt for passive biometric unlock (e.g. iris/face)

## [0.9.0] - 2020-05-01

### Added
- Add banner at top of library when downloaded only mode is enabled
- Add ability to inspect WebView in debug builds
- Add logo header in more section
- Add row dividers in source migration list
- Add bottom padding to library for ActionToolbar
- Added Local Source icon
- Add links to local source guide
- Added Last Used header to browse
- Add Start/Finish date support for MAL
- Add offline mode (forced download filters; closes #2902)
- Add link to website and open source licenses
- Add confirm exist setting
- Add function in interface to get list of genres
- Add parent class for view configs
- Add source pinning
- Add text to chapter FAB, shrink extended FABs on scroll
- Add padding for catalogue filter FAB
- Add support for margins in Webtoon view
- Add continuous vertical to default reader options
- Add Continuous vertical reading mode
- Add select inverse action
- Add update library menu item
- Add fast scroller to library
- Add fast scroller in catalogues/extensions lists
- Add end pending for catalogues/extensions group header for RTL names
- Add icon for mark previous as read
- Add download queue features from J2K fork
- Add dev notice about background jobs, move dialog titles for localization
- Address some build warnings
- Added config to hide transition page when not needed
- Add an UserAgent Interceptor to Cloudflare Client
- Add (disabled) dependency on LeakCanary for debugging memory leaks
- Add shortcut to disabling battery optimization
- Add history date section headers
- Add setting to hide manga content from update/download notifications
- Add ripple to menu icons
- Add description for secure screen setting
- Add ktlint
- Add shortcut to manage app notifications
- Added Webtoon with Padding viewer
- Add secure screen setting
- Support follow system theme[Android 10]
- Add bookmarking to chapter selection menu
- Additionally sort by chapter number in recent updates
- Add ability to explicitly remove tracking from track search dialog
- Add tracker logout dialog
- Add select all menu option for library category
- Add descriptions to reader prev/next buttons for a11y
- Add larger minimalistic splash screen icon
- Added a app loading splash Screen
- Add fast scroller to library

### Changed
- Release 0.9.0
- Translated using Weblate (Ukrainian)
- Always update extensions list on enter
- Always update sources list on enter
- Update Bangumi link in README
- Default library updates to daily + wifi
- Reword action button in source filter sheet
- Ignore built files
- Set backup/restore progress notifications to low priority
- Update screenshots in README
- Move google-services.json
- Increase next chapter preload threshold to last 5 pages
- Split out backup/restore notifications into separate channels for progress/completion
- Minor empty state string edits
- Move google-services.json
- Disable entire checkbox view when disabled
- Adjust size of more header
- More settings organization
- Option to only include pinned sources in global search
- Move extension update preference to settings
- Set up extensions check job on update
- Make search views take up full width
- Ensure ActionToolbars don't overlap snackbars or FABs
- No longer using chapter url for new chapter notification's reader intent
- Use same header layout for sources/extensions/migration
- Handle paused state in download queue summary
- Refactor tabbed bottom sheet
- Show download progress in MoreController
- Minor edits
- Copy files from cache when downloading
- Revert hiding cutout setting from reader sheet
- Dependency updates
- Increase default connect/read timeouts
- Pull basic manga/chapter metadata from EPUB files.
- Revert column FlowPreference
- Only apply downloaded only to chapter lists in library
- Edge fade for compact genre chips when scrolling
- Restore landscape manga info layout
- Revert removal of last chapter/updated from manga info
- Merge sources and extensions into one view
- Hide titles in restore notification based on preference
- Translated using Weblate (Finnish)
- Translated using Weblate (Finnish)
- Hide EmptyView when retrying source request
- Copy debug info when tapping version
- Include viewer and chapter filter preferences when migrating manga
- Migrate column preference to FlowPreference
- Set preference visibility immediately
- Refactor backup service
- Placeholder link to next release changelog
- Improvements to EPUB support.
- Move some restore notification logic into service
- Consider individual manga as transactions rather than entire restore job
- Some restore code refactoring
- Localize some restore strings
- Return success/failure result for backup job
- Update top level project build scripts
- Linting fixes
- Simplify outlined button style name
- Minor edits
- Tweak ActionToolbar styling
- Revert some seekbar event listener changes
- Enable Gradle caching
- Minor cleanup
- Replace some listeners with flowbindings
- Refactor library sheet into tabs
- Show scrollable single line of genres when compacted
- More FlowPreference migration
- Adjust sources section heading padding
- Link to GitHub commits for preview build changelog
- Reduce size of history card titles
- Revert Material Dialogs to v3.1.1 due to weird UI blinking/cutoff issues
- More FlowPreference migration
- Change favorite icon to heart
- Separate categories picker from long pressing manga favorite button
- More subdued chapter page progress text
- Replace Track Reading Dates date picker with MaterialDialog's one
- Hide reader cutout setting if no cutout detected
- Group version info at top
- Make restore a foreground service
- Update nucleus library
- Update README.md
- Migrate more preferences
- Move common view configs to parent class
- Specify Stable vs Preview in version
- Set default textInputStyle
- Replace TextDrawable with a Kotlin fork
- Replace deprecated adapterPosition with bindingAdapterPosition
- Make entire history item card clickable
- Use existing paddings when allocating space for source RecyclerView for FAB
- Update Material Dialogs
- Move restore progress dialog to notification
- Prevent multiple concurrent backups/restores
- Move restore completed/error dialogs to notifications
- Fully move backup progress/created dialog logic to notifications
- Bug/2894 covers not updating
- Use lifecycle scope for flows in activities
- Replace backup progress dialog with notification
- Complete RxBindings to FlowBinding migration
- [CI SKIP] More consistent "WebView" wording
- Force close app if Webview isn't available
- Rename offline mode to downloaded only
- Default skip filtered to true
- Change restore error log extension to txt
- Minor edits
- Use non-deprecated Kotlin experimental flag
- Replace some old color attribute usages
- Translated using Weblate (Portuguese (Brazil))
- Translated using Weblate (Swedish)
- Translated using Weblate (Swedish)
- Show locale name in system default locale
- Avoid multiple reader instances
- Include bookmark state when migrating chapters
- Genre search from updates/history
- Minor style tweaks
- Lint fixes
- Bump minimum extension lib and WebView versions
- JDK8, lint fixing
- Webtoon zoom out
- Refactor databinding fields to parent abstract classes
- More consistent card radii
- Tweak outlined library icon more
- Collapsable manga summary/genre section
- Round manga info cover
- Tweak library icon
- Revert attempted WebView process fix
- More FlowPreferences migrations
- Extension function instead of redefining uiScope everywhere
- Extra genre chip text trimming
- Toggle reader menu if transition by tapping are disabled
- Replace colorPrimaryDark with colorPrimaryVariant
- More FlowPreferences migrations
- Migrate some RxSharedPreferences to FlowSharedPreferences
- More rxbindings migration
- Use HTTPS for crash reports
- Mostly migrate rxbinding to Kotlin Flow version
- Manga info action buttons
- Scrolling manga info view
- Make immersive mode slightly more reliable on rotation
- Move bitmap images to nodpi
- Gradle and travis updates
- Prevented overzealous preloading
- Minor edits
- Update Acra
- Rename "Local manga" -> "Local source"
- Crash fixes
- Rounded library covers
- Use native fontFamily support for library titles
- Tweak tracking card UI
- Controllers now properly remove their toolbar items on pop
- Replace some icons
- Rename catalogue classes/layouts -> source
- Default reader theme to black
- Prioritize pinned sources in global search
- Hide filter FAB in source latest
- Temporary workaround for chapter FAB being invisible
- Use explicit file url instead of download manager's content url
- Move search filter sheet actions to the top
- Use LinearLayout as root of main_activity
- Use FAB for catalogue filter
- Show open in webview menu icon if room
- Migrate to ViewBinding in ReaderActivity
- Move catalogue filters to bottom sheet
- Minor updates
- Open decode error pages in webview instead of browser
- Tweak webtoon margin setting
- Merge branch 'jleehey-feature/webtoon-margins' into pr/2349
- Merge branch 'feature/webtoon-margins' of git://github.com/jleehey/tachiyomi into jleehey-feature/webtoon-margins
- Bind the margin ratio as a float preference and rename variables
- Revert "Remove no-longer-needed FloatListPreference"
- Use colorSecondary for text field cursor
- Migrate to ViewBinding in WebviewActivity
- Update Gradle
- Translated using Weblate (Turkish)
- Change color of 'last page read' in chapter description
- Migrate to ViewBinding from Kotlin synthetics in controllers
- [CI SKIP] Update issue_closer.yml
- Create issue_closer.yml
- Minor cleanup
- Duplicate Hebrew strings on build for legacy locale code
- Sort languages, add Hebrew
- Translated using Weblate (Turkish)
- Tweak string comparison to account for length
- Update library shortcut icon
- Update tracker icons
- Close response before proceeding chain
- Tweak dark theme snackbar
- Perform catalogue search when genre tag is tapped
- Update issue templates
- Perform local search when source is tapped from manga info
- Show error toast when extensions list fails to load
- Cache source package icons
- Show extension icons in source filtering view
- Using extension icon instead of letter for catalogues
- Reword "Catalogues" to "Sources" for user-facing consistency
- Respect chapter list filtering when reading
- Update jsoup
- Make migration manga-centric rather than source-centric
- Translated using Weblate (Sardinian)
- Replace genre tags on refresh
- Minor edits
- Hide catalogue empty view properly
- Replace TagGroup library with Material chips
- Tweak error button appearance
- Use bottom sheet for library settings
- Use pill icon instead of text for sheet pull up indicator
- Revert "Move library display settings out of filter sidebar"
- Show empty catalogue error view with actions
- Bookmark via reader
- Limit foreground extension checks to once a day
- Consistent "WebView" wording
- Minor dependency updates
- Prompt user to open WebView on HTTP errors
- Tweak button styles
- Rename "Last updated" sort to "Last checked"
- Update WorkManager
- Minor extension update cleanup, default to on
- Option to auto check for extension updates
- Tint chapter filter icon if filters are enabled
- Faulty preload fix
- Manually fix zh-rCN plural strings
- Use solid/outline check icon for mark as read/unread
- Mostly revert back to old filled icons
- Translated using Weblate (Hindi)
- Always recreate activity on light theme change
- Minor dependency updates
- Use actual dialog title for tracker login dialogs
- Replace more icons
- Changed default pager zoom style to ZOOM_FOCUS_CENTER
- Tweak tab indicator style
- Left-over batch of translations
- Translations (Continuous)
- Use immersive sticky flag when hiding reader UI
- Pure white light theme
- Filled icons in bottom nav when selected
- Move filter icon tint color to resources
- Replace more icons
- Use outlined icons in settings
- Use outlined icons in bottom nav and more controller
- Match status/nav bar color with toolbar
- Bump updates/history limit to 3 months
- Replace deprecated Gson JsonParser usages
- Ensure background jobs are recreated after next stable update
- Dark snackbar in dark themes
- Prune inherited/add missing base theme attributes
- Migrate to MaterialComponents themes
- Flip mark as (un)read icons back
- Use accent color for refresh circle
- Simplify track item layout to use LinearLayout instead of nested ConstraintLayouts
- Flip bookmark icons to match manga favoriting
- Tweak compact tracker card design
- Simplify viewer check
- Random kaomoji for empty view
- More consistent usage of visibility extensions
- Update visible pager settings on change
- Compact tracker card
- Change new chapters string key
- Start preloading next chapter if within last 3 pages instead of last page
- Update Kotlin and coroutines
- Minor cleanup
- Hide download/delete actions when sensible, make bookmark/read toggle actions
- Bottom action menu in chapters list
- Action toolbar code cleanup
- Translations (Continuous)
- Bottom action menu in library
- Tweak how bottom action menu is configured
- Abstract bottom action menu code to main activity
- Bottom action menu for updates
- Shorten "Remove bookmark" to "Unbookmark"
- Label Kitsu login field as email address instead of username
- Reorder start screen options to match bottom nav
- Avoid passing max chapter number from tracker
- Match status/nav bar to reader toolbar color
- Minor lint fixes
- Show page number only when toolbar is hidden
- Page # before scanlator in chapters list
- Revert DialogController syncing change
- Document changes to date for stable changelog
- Tweak saved filename byte size limiting logic
- Enable app auto update by default
- Pass context to get WorkManager instance
- Rename recently read / recent updates classes/layouts to match new names
- Combine chapter date/scanlator lines
- Use recognized chapter number boolean field for filter
- Hide bottom nav on non-root controllers
- Linting fixes: extend AppCompat classes
- Limit saved page filenames to 127 characters
- Move security settings to separate section
- Update Firebase
- Change catalogue hiding dialog to accommodate more options in the future
- Update WorkManager
- Minor code cleanup
- Tweak manga favoriting logic
- Use proper AndroidX WorkManager dependencies
- Basic implementation of hiding catalogue by long pressing
- Update versions plugin
- Revert "Remove unused Google Play Services plugin"
- Update Proguard rules
- Reenable Proguard
- Bump up max JVM heap size for project
- Tweak new chapters notification wording
- Tweak WorkManager task cancellation, add flex times
- Migrate to WorkManager
- Minor wording tweaks
- Log in, out, marked noun, small versals
- Update android-job library
- Translations (Continuous)
- Merge branch '0.8.x'
- Reword unlock string
- Change system dark mode check
- Tweak more screen to remove top padding
- More preference grouping
- Always show bottom nav labels
- More linting fixes
- Run linter
- Migrate to bottom navigation
- Update lifecycle library
- Update Gradle
- Rename/new icons for updates/history sections
- Avoid crash on loading invalid extension
- Move crash reports setting to advanced
- Refresh webtoon adapter on image property changed
- Set webtoon page padding on page bind
- Hide null file path on backup creation
- Reword "Clear" to "Cancel all" in download queue
- Move color filter behind reader toolbars
- Biometrics lock
- Run formatter on layout files
- Minor layout tweaks for better RTL support
- Revert usage of AndroidX Webkit library
- Default to light theme prior to Oreo
- Change default theme to System Default
- Dark mode splash screen
- Minor system theme tweaks
- Run default Android Studio formatter on resources
- Run default Android Studio formatter on code
- Change chapter update notification to show chapter numbers
- Perform mark as read action in IO coroutine scope to avoid freezing app
- Refactor notification manga cover logic, decrease size
- Separate group for extensions with updates
- Simplify Tachiyomi vector icon
- More notification code cleanup
- Minor cleanup
- Simplify "and n more" string
- Group notifcations for Library updates
- Hide share icon for manga info if not from online source
- Allow selecting default category for auto download
- Compare recent updates by both date and chapter number
- Simplify selected count to just show the number
- Merge pull request #2596 from FlaminSarge/migrate
- Move empty-chapterlist manga to end of Latest Chapter sort in Library view
- Show URL in Webview subtitle
- Switch to AndroidX Webkit library
- Slightly increase chapter cache size
- More coroutine network call fixes
- Library search for source
- Library View: Add latest chapter sorting and revert last updated sorting changes
- Change latest chapter sort string to "Latest chapter" instead of "Last chapter"
- Library View: Add latest chapter sorting and revert last updated sorting changes
- Only show Webview update prompt if CF bypass fails
- Lower minimum Webview version warning
- Restrict translucent reader UI to API 26+
- Use coroutines for updater
- Refactor notification builder extension
- Translucent reader UI
- Show message if WebView version is too low
- Translations (Continuous)
- Move library display settings out of filter sidebar
- Minor edit to onOptionsItemSelected fallthrough logic
- Minor section name edits
- Move PreferenceDSL
- Restore setting controller fade
- Group tracking setting activities
- Reword "directory" to "location"
- Move help into settings menu
- Include commit SHA in dev version info
- Explicitly switch between IO/UI dispatchers when updating list of extensions
- Throw exception in okhttp coroutine if response isn't successful
- Update to Material Design library 1.1.0
- Move JsoupExtensions back
- Migrate extension list fetch to coroutine
- Reorganize other util files
- Reorganize some util files
- Move edit categories to library settings
- Categorize library settings
- Filter out tmp directories for download badge
- Use coroutines for async loading of modules
- Update AndroidX SQLite dependency
- Convert root level Gradle files to Kotlin DSL
- Optimize imports
- Minor date format code cleanup
- Allow setting a preferred date format
- Reroute all deep links through DeepLinkActivity to provide more control
- Fr using $s instead of $d
- Rename sources settings to filter
- CloudflareInterceptor update
- Vector tracker icons (except Bangumi)
- Tweak initial tracker card appearance
- Minor formatting
- Tweak manga last updated time based on chapter upload instead of fetch time
- Directly pass read chapter when updating tracker
- Use black background for AMOLED theme cards, dialogs
- Minor dependency updates
- Download dialog in chapters removed, now using submenu
- Tracker status naming edits
- Bug/2513 edit text preference crash
- Do not suppress a type system error
- Set manga last update field based on chapter fetch time
- Update tracking controller after logging in to Bangumi
- Rename "On hold" to "Paused"
- Replace raster icons
- Move "Open in browser" option to webview only
- Use smaller CustomTarget for shortcut creation
- Minor cleanup
- Filter library items by artist as well
- Local genre tag searching
- Minor reader bugs:
- Force menu invalidation when expanding actionView from user interaction to properly layout menu items
- Webview enhancements
- Update Firebase
- Build time now opens changelog
- Indicate obsolete extensions
- Restore transparent status bars, allow WebView app bar to scroll away
- Tweak reader seekbar height for Android 5 UI bug
- Run formatting on test package
- Rename tracker icon images
- Translations (Continuous)
- Mark JAR as binary too
- Revert "Renormalize files"
- Renormalize files
- JSON metadata for local manga
- Implement long hold selection for Manga Chapters and library
- Minor extension filter cleanup
- Filter Extensions By Language
- Update BackupTest.kt
- Minor grammar fixes
- Show selected preference for "Library update order"
- Convert webview into an activity
- Allow user to retain app data on uninstall for Android 10
- Mark webp as binary files for git
- Tweak splash screen color, set nav bar to match
- Use OutlineSpan approach from CarlosEsco/Neko to avoid infinite redraws
- Revert "Remove reflection to get TextView color field "
- Split general settings into general and library
- Update to SDK 29 (Android 10)
- Replace left/right layout attributes with start/end
- Convert filter mock image to webp
- Convert tracker icons to webp
- Convert nav drawer icon to webp
- Clean up splash screen code
- Don't enforce line endings on binary files
- Provide more human readable error when downloading to invalid directory
- Tweaks based on PR comments, simplify some more strings
- Language rework
- Restore equals/hashCode in ChapterTransition
- Replace usage of deprecated Glide SimpleTarget
- Minor code cleanup
- Drop support for Android 4.x
- Made 'Default' category selectable in global update settings
- Convert remaining Java files
- Match transition text used by other readers
- Update files to use unix line endings
- Enforce unix line endings
- Update conductor-support-preference for AndroidX preference v1.1.0 compat
- Improve Loading Speed When Skipping Pages in a Chapter
- Migrate to AndroidX

### Fixed
- Fix some sheet color issues
- Fix copy paste mistake in PreferencesHelper.kt
- Fix download queue cutting off if too short
- Fix snackbar/FAB overlap in edit categories view
- Fix top padding in sources tab
- Fix extensions intent
- Fix crash when tab isn't available
- Fix BrowseSourceController losing scroll position when navigating back
- Fix typo
- Fix ActionToolbar background color
- Fix categories button not working after adding manga
- Fix round text icons
- Fix extended fab height, make text bolder
- Fix backup/restore notification channel
- Fix manga info expansion toggling again after refreshing
- Fix extension update badge again
- Fix extension update badge in bottom nav not updating
- Fix extension setting dialogs not handling duplicate keys
- Fix string key typo
- Fix for library tags not triggering search
- Fix switch style in reader settings sheet
- Fix webview back/forward button color
- Fix status/navigation bar colors
- Fix for Filter.Select labels jumping on filter sheet reloading
- Fix invisible back/forward webview icons in white them
- Fix zh-rCN plural strings
- Fix shortcuts popping up library sheet or duplicating controllers in backstack
- Fix multiple chapters notification grammar
- Fix spacing in chapters notification
- Fix bottom nav background color
- Fix catalogue display mode icon tint
- Fix for perpetually loading chapters
- Fix webview close button tinting
- Fix focused text input stroke color
- Fix common toolbar popup menu text color
- Fix list divider color in dark themes
- Fix reader background color
- Fix overlapping shadow in history controller
- Fix sheet pager setting visibility when default is webtoon
- Fix secure screen option subscription memory leak
- Fix bug where status cannot be updated when all chapters have been read.
- Fix Cloudflare Interceptor when User-Agent is Empty
- Fix library empty view alignment
- Fix chapter list item end padding
- Fix some changelog wording
- Fix activity UI state when activity is killed
- Fix chapter description and download badge overlap
- Fix fullscreen reader for notch device
- Fixed extensions call running on main thread
- Fix NPE in dateFormat
- Fix sources/extension filters toggles being indented
- Fixed extensions showing as obsolete when call fails
- Fix catalogue search focus automatically being removed
- Fix Bangumi class formatting
- Fix bangumi track will override record to 0 after every track search(bind)
- Fixed file permissions for Android 10
- Fix splash screen status bar color
- Fix filter_mock
- Fix stretched splash screen icon on older versions of Android
- Fix bangumi tracker crash in searching english manga title
- Fix DOWNLOADED text showing after chapters are marked as read

### Removed
- Remove unnecessary checks
- Remove unnecessary dialog padding dimens
- Remove usage of alpha color selectors
- Remove redundant DB transaction function
- Remove TextDrawable
- Remove vector drawable support library flag
- Remove option to turn off app update checks, check every 3 days
- Remove migrating progress dialog
- Remove source name from history cards, slightly compacter
- Remove some progress dialogs
- Remove unused widget styles and animations
- Remove custom preference flow implementation
- Remove manga homescreen shortcuts
- Remove redundant call to set extension badge in bottom nav
- Remove some relayed chapter info from main manga info view
- Remove unnecessary reader sheet backgrounds
- Remove maxWidth logic from SimpleNavigationView since it's not a sidebar anymore
- Remove no-longer-needed FloatListPreference
- Remove unused string
- Remove dead code from DownloadQueue
- Remove elevation overlay
- Remove letter spacing from buttons
- Remove unused colors
- Remove unnecessary lint suppression
- Remove chapter item popup menu
- Remove chapter updates popup menu
- Remove unused layout
- Remove unused Google Play Services plugin
- Remove unused icon
- Remove unused LoginSource
- Remove unused navigation header dimens
- Remove usages of incorrect platform yes/no strings
- Remove library sort by source
- Remove unused RxJavaCallAdapterFactory for app updater
- Remove star icon option
- Remove unused layout
- Remove round icon asset
- Remove unused SharedData object
- Remove display/sorting mode dialogs
- Remove fast scroller from library
- Remove reflection to show tracking checkmark
- Remove unused drawables
- Remove unused string
- Remove clickable attributes from unclickable text in reader
- Remove unused FAB animations
- Remove reflection to get TextView color field
- Remove up/down animation for FAB, add list padding
- Remove unused color resource
- Remove repository for Conductor snapshot
- Remove unnecessary legacy-support-v4 dependency

## [0.8.5] - 2020-02-29

### Added
- Add warning on update check for Android 4.x users
- Add width and height to listview for browseCatalogueController
- Add REQUEST_DELETE_PACKAGES permission for uninstalling extensions
- Address minor Kotlin compiler warnings
- Add .nomedia file in each chapter download folder
- Add chinese track website "bangumi"
- Add automatic updates for dev builds
- Add help link to nav drawer
- Add color filter blend modes
- Add options to open catalogue in browser/webview

### Changed
- Release 0.8.5
- Hide null file path on backup creation
- Enforce maximum extension lib version of 1.2
- Avoid crash on loading invalid extension
- CloudflareInterceptor update 	dcd3c709	Mike <51273546+SnakeDoc83@users.noreply.github.com>	Jan 25, 2020 at 16:37
- Directly pass read chapter when updating tracker
- Minor reader bugs:
- Build time now opens changelog
- Tweak reader seekbar height for Android 5 UI bug
- Provide more human readable error when downloading to invalid directory
- Made 'Default' category selectable in global update settings
- Match transition text used by other readers 	708525ef	Carlos <cargo8005@gmail.com>	Jan 5, 2020 at 17:59
- Unix line endings
- Improve Loading Speed When Skipping Pages in a Chapter
- Adjust so downloader doesnt autostart when queue was paused
- Auto attempt a login refresh once if MAL returns http 400
- Update JSoup
- Recycler is not fixed size
- Tweak FAB sizing method
- Replace dependency for case insensitive natural sorting
- Enable Java 8 language feature support
- Minor dependency updates
- Update project-level dependencies
- Allow cleartext traffic
- Update to SDK 28
- Increase default text size of the transition chapter page
- Allow back button to navigate to previous URL in WebView, add Forward, Refresh, and Close menu options
- Update DB architecture component
- Update to Kotlin 1.3.61
- Update coroutines
- Update Gradle
- Upgrade Kotlin (to 1.3), Coroutines, Gradle, and Android Gradle…
- Merge branch 'master' into update-kotlin-coroutines-gradle
- Clean up Anilist GraphQL query formatting
- Update to build tools v29.0.2
- Update to latest version of Android support libraries
- Extract some hardcoded strings
- Update README.md
- Update README.md
- Improve Issue reporting experience
- Allow 'Default' category as the default for adding manga
- Implemented extension search functionality.
- Set glide to use the gif loop count
- Group available extensions by language
- Merge pull request #2271 from mezzode/patch-1
- Update link in FAQ
- Change "Help" link from Github Wiki to Website
- Changed README's app screenshot
- Update translation files
- Translations
- Upgrade Kotlin (to 1.3), Coroutines, Gradle and Android gradle plugin.
- Update to kotlinx.coroutines 0.30.2
- Update deprecated coroutines code
- Update to kotlinx.coroutines 0.26.0
- Update to kotlinx.coroutines 0.23.4
- Update info about auto updates in README
- Hide Empty Search Results in Catalogues
- Avoid infinite loading in global search if a single catalogue fails
- Use dist: trusty
- Change default update priorization
- Update ranking
- Make MAL Tracking Slightly Less Shitty
- Long click to manage categories
- Update tracking sites after finishing chapter
- Ignore case while sorting Library
- Create FUNDING.yml
- Update Shikimori
- Bugfix. Sharing images with very long name
- Update README.md
- Shikomori -> Shikimori. Fix update chapters
- Force Migration to display titles from source rather than from local DB, and update local titles when migrated

### Fixed
- Fix bangumi track will override record to 0 after every track search(bind)
- Fix bangumi tracker crash in searching english manga title 	eb5382e0	mutsumi <4182301+mutsumi63@users.noreply.github.com>	Jan 6, 2020 at 20:02
- Fix DOWNLOADED text showing after chapters are marked as read 	df14e6d4	Carlos <cargo8005@gmail.com>	Jan 5, 2020 at 16:36
- Don't send newlines and whitespace in API calls
- Fix jitpack cause it's shitting out
- Fix coroutine deprecations again
- Fix the category selection bug

### Removed
- Remove FAB animation files left over from bad cherry picking
- Remove clickable attributes from unclickable text in reader
- Remove unused FAB animations
- Remove up/down animation for FAB, add list padding 	e411f542	arkon <arkon@users.noreply.github.com>	Jan 8, 2020 at 21:33
- Remove unused color resource
- Remove repository for Conductor snapshot
- Remove minSdkVersion 21 for dev builds (no longer needed for multidex)
- Remove redundant "publishNonDefault" setting

## [0.8.4] - 2019-04-13

### Changed
- Release 0.8.4
- Disable proguard

## [0.8.3] - 2019-04-13

### Added
- Add intent filter for external queries
- Add option to open manga details in a WebView
- Added search intent handler and Google Search Action, for the global search
- Add option to skip chapters marked read
- Feature/shikomori track
- Add 32-bit color mode to reader settings

### Changed
- Release 0.8.3
- Use single task activity
- Enable new translations
- Translations
- Load urls inside webview
- Provide default web view client so that redirections work
- Use OkHttp to solve the challenge
- Test solving Cloudflare's challenge with WebView
- Set explicit autobackup rules

### Fixed
- Fix lint issues on new strings
- Fix shared files not deleted from internal cache
- Fix crashes below L
- Fix discord link

### Removed
- Remove internal sources

## [0.8.2] - 2019-03-27

### Changed
- Release 0.8.2
- Storio imported from Jitpack. Also fix an issue with the progress bar animation on the reader
- Update ISSUE_TEMPLATE.md
- [Cloudflare] Fix recent CF JS Challenge error that calls DOM
- [Cloudflare] Fix 503 due to missing value in js challenge.

### Fixed
- Fix bug with update lib and parse chapters
- Fix strings and add new languages

### Removed
- Remove F-Droid on README.md

## [0.8.1] - 2019-03-15

### Changed
- Release 0.8.1
- Extract hardcoded strings from layouts
- Translations
- [Cloudflare] Fix SyntaxError due to recent js challenge changes.
- Reduce priority of jcenter repository
- [Anilist] Fix date parsing error
- [Anilist] Fix tracking for re-reading status
- Bundle SQLite. Fixes tachiyomi not working on KitKat. Making a backup before using this version is recommended, but everything should work.
- Translations
- Changed repository order for gradle
- MAL API Workaround
- Optimize library query
- Kitsu search fix
- Filter local manga as downloaded
- Restore dark blue theme. Closes #1302
- Update Anilist API search to return 50 results
- Allow pausing downloads from progress notification

### Fixed
- Fix Glide exceptions
- Fix Amoled navigation bar colour on OxygenOS
- Fix issue with center zoom position
- Fix potential NPE at cover image selector

## [0.8.0] - 2018-10-09

### Added
- Add new translations to settings
- Add categories for readmanga/mintmanga

### Changed
- Release v0.8.0
- Update kotlin and build tools
- Minor fixes when updating the manga viewer
- Better page transition text alignment
- Don't use full-width page sheet on big landscape screens
- Update Android Studio and gradle
- Update mangasee URL
- AniList 5-star/smiley <-> 100-point values differ from the AniList website
- Translations
- Handle manga info fetch errors in the same way as chapter fetch errors
- For migration, put the selected source at the top of the search list instead of excluding it
- Update subsampling library with decoder fixes
- Update image decoder library. Remove deprecated ask update tracking setting
- Show menu when there's no next chapter
- Several reader fixes
- New reader
- Set notification number for library updates to number of new updates
- Update manga.last_update when any ChapterSourceSync.syncChaptersWithSource() occurs rather than only during LibraryUpdateService.updateChapterList()
- Kitsu search fix
- Only include URL in the share functionality
- Show manga with no installed source. Based on PR #1345
- Changed Kitsu to use Algoria search directly
- Update ISSUE_TEMPLATE.md
- Update AnilistModels.kt
- Update date selector and chapter number recognition
- Update user agent on kissmanga ¯\_(ツ)_/¯
- Change AniList search query to show some previously hidden entries.
- Bugfix on save instance state. Also improve initial page loading on Kissmanga

### Fixed
- Fix NSFW Manga not showing in Kitsu
- Fix volume keys intercepted even if the setting was off
- Fix kissmanga not loading for some people after the previous update

### Removed
- Remove unused string

## [0.7.4] - 2018-05-13

### Added
- Added Github link to about.

### Changed
- Release v0.7.4
- Vanity url
- Reenable cipher suites after upgrading to okhttp 3.10. Fixes #1411
- Update okhttp version
- Minor fix
- Implement Anilist API v2
- Update README.md
- Bugfixes

### Fixed
- Fix indonesian language. Closes #1387

## [0.7.3] - 2018-04-28

### Added
- Add new translation link

### Changed
- Release v0.7.3
- Run downloader in foreground service
- Reorganize reader settings. Update Conductor version
- Crop borders for webtoon now have a separate setting. Close #972
- Workaround a crash related to saving instance state and child controllers
- Include firebase analytics
- Separate 'en' locale into 'en-US' and 'en-GB' for displaying dates
- Update strings.xml
- Update russian sources

### Fixed
- Fix #1073
- Fix tracking search layout

### Removed
- Remove F-Droid.org link

## [0.7.2] - 2018-04-08

### Changed
- Release v0.7.2
- Use our OkHttpClient in updates checker. It should fix the updater on KitKat due to TLS

### Fixed
- Fix #1351
- Fix downloaded text drawn outside the screen

## [0.7.1] - 2018-04-05

### Changed
- Release v0.7.1
- Show last update if date > 0
- Update constraint layout & fix broken layouts
- Provide accept & accept-language to cloudflare
- Don't send cache control with cloudflare challenge
- Update travis script
- Update cloudflare interceptor and android studio
- Enable TLS 1.1 and TLS 1.2 on Android KitKat (and older)
- Dialog color fix
- Update Batoto toString() method to support downloaded chapters

### Fixed
- Fix typo in layout

## [0.7.0] - 2018-03-11

### Added
- Added country/region support for locale when displayed for sources
- Add logging to controller lifecycle to help reproducing bugs
- Add missing languages in settings
- Add override status back in
- Add notice for updating extensions
- Add page down/page up hardware detection
- Add option to change double tap animation speed in the reader
- Added custom download option
- Add referer to readmanga/mintmanga requests header

### Changed
- Release v0.7.0
- New colors + theme attrs
- Kotlin update
- Anilist search fix
- Update Kissmanga genres
- Bugfixes and extension installation improvements
- Update conductor to latest snapshot (with a minor fix)
- [WIP] Translations
- Update available extesions whenever the screen is opened
- Change Source Migration menu item to use string resource
- Travis update
- Forgot the backup manager isn't injected
- Run periodic backups without launching services
- Dependency updates
- Chapter Metadata update
- Improve tracking search results
- Update README.md
- Library filter UI change
- Sort extensions by package name. Minor changes to extension installer
- Timeout the installation of extensions after 10s
- Downloading extensions from Github Repo.
- Adjusted chapters item since Android 16 doesnt support right and left
- Hide latest button when source doesnt support latest
- Ask for permission if necessary when browsing local sources.
- Updated mangahere to show licensed status
- Catalog visuals update 1155
- Increase touch area for 3 dot in chapter list
- Information Page Improvements (click to search, copy to clipboard, etc)

### Fixed
- Fix info layout + disable tag clicks for now
- Fixes and Tweaks to Info Page
- Fix subtle bugs when installing/loading extensions
- Fixed marked previous as read not deleting chapters
- Fix imports from last commits
- Fix restore from old backup to updated trackimpl.
- Fix duplicate entries in source migration. Closes #1190
- Fix extensions installer on old Android versions. Fix deadlock on devices with 1-2 cores
- Fix author/artist not showing in mangahere
- Fix genre tags to be delimited correctly
- Fix chapter recognition regex and detail number
- Fix library query being lost
- Fixed 3 dot icon
- Fixed alpha not showing for manga in library during global search
- Fixed ReadMangaToday search issue

### Removed
- Removed extra blank lines
- Remove debug log
- Remove batoto from catalogues
- Remove simultaneous downloads
- Remove teal background

## [0.6.8] - 2018-01-16

### Added
- Add adaptive icon and a dev variant
- Add error handling to migrations
- Add a new screen to help migrating manga from sources

### Changed
- Release v0.6.8
- Migration now opens manga on long click
- Use a single preference to store migration flags
- Handle ActivityNotFoundException

## [0.6.7] - 2018-01-09

### Added
- Address #1154

### Changed
- Release v0.6.7
- Include minor changes from extensions PR
- Update README
- Mangachan advanced support
- Small new user improvements
- Update MangaChan.kt
- [Mangafox] update mangafox URL for built-in source
- Change discord invite link in settings
- Update regexp for pages from Readmanga/Mintmanga

### Fixed
- Fixed issue where some sources that use cloudflare use the Server: cloudflare as cloudflare-nginx is deprecated
- Fix padding in RecyclerViews

### Removed
- Remove local broadcast receiver to prevent race conditions

## [0.6.6] - 2017-12-05

### Added
- Add view caching to view holders
- Add install packages permission. Fixes #1104

### Changed
- Release 0.6.6
- Restore tracking on backup
- Give view pager unique ids, avoiding subtle bugs
- Repackage catalogue to match the UI
- Use synthetic view's new caching method
- Dependency updates
- Start downloader after a library update. It should help with some catalogue issues

### Fixed
- Fix library not being updated
- Fix library options menu shown in chapters screen. Resolves #1096

## [0.6.5] - 2017-11-29

### Changed
- Release 0.6.5
- Resubscribe to library when a change of type enter occurs. Resolves #1093
- Minor changes to download cache. Also keep the library view, as recreation is expensive
- FIx Batoto issues with logging in and loading lists/pages.
- Update build tools in travis
- Implement a download cache
- Update support library and kotlin

### Fixed
- Fix automatic backups

## [0.6.4] - 2017-11-23

### Added
- Add concurrency to global search queries
- Added Cloudflare email obfuscation bypass for kissmanga
- Added extra padding on page number to prevent cut off on rounded corner devices.
- Add library manga class
- Support notification channels. Fixes #995
- Add option to sort library by source.
- Added licensed element check for MangaFox
- Added regex to strip local manga chapter names

### Changed
- Release 0.6.4
- Translations
- Update page indicator colors and new Readmangatoday domain
- Page indicator now uses an outline instead of overlapping shadows
- Move page indicator to bottom center, and use a shadow instead of a background. Other category in catalogue list is now placed at the end
- A few fixes and dependency updates
- Fallback covers' external directory
- Undo last commit
- Share image with both setData and extra stream intent
- Update subsampling. Export /storage/ to SAF
- Update flexible adapter. Show fast scroller in chapters screen
- Restore previous query in global search. Closes #1040
- Build command and paths also changed
- This one should finally fix travis builds
- Trying to fix broken travis
- Use gradle's new dependencies API. Update a few dependencies
- Update Android Studio to 3.0
- Use new key format in badges preference
- Download count shouldn't be stored as a database field
- Download badge
- Actually use latest Glide version. Minor doc fix
- Glide v4
- Library updater is now a foreground service
- Introduce coroutines. Fix #1027. Lower notification channels' importance
- Shortcut fix Oreo
- Forgot to add semicolons
- Don't decode secrets for PRs
- Reversed some things from AMOLED update
- Use default tools
- Clone NDK for Travis
- Travis deployment
- Update android sdk in travis
- Also set system locale with the Java API. Closes #978
- Trust mangahere certificate for now...
- Improved AMOLED theme. Added Button style for borderless buttons.
- Target sdk 26. Dependency updates.
- Global Search

### Fixed
- Fix #764. Update Kissmanga genres
- Fix crash downloading of manga from Readmangatoday
- Fix some crashes
- Fix extra (advertisement) page being added in Mangahere.
- Fix covers url on Mangachan.
- Fix many compilation warnings
- Fix test
- Fixed author/artist not showing for Mangahere.
- Fix app freezes when queueing many chapters with SAF. Closes #817
- Fix wrong downloaded percentage when server doesn't send content length. Fixes #1019
- Fix commit count in travis' build
- Fix downloads from mangahere
- Fix search on readmanga/mintmanga

### Removed
- Remove teamcity badge. Fix deploy script

## [0.6.3] - 2017-09-10

### Changed
- Release 0.6.3
- Actually convert file uri to content uri
- Disable file exposure detection to allow sharing from the local cache ¯\_(ツ)_/¯

### Fixed
- Fix #908
- Fix a crash when retrying a page

## [0.6.2] - 2017-09-09

### Added
- Add Filter by Completed for library
- Add Batoto Scanlator to Chapter view
- Add workaround for disappearing menu items

### Changed
- Release 0.6.2
- Lock drawer with gravity parameter instead of a view
- Exclude extensions dependencies from proguard. Enable new translations.
- Translations
- Simplify presenter delegate
- Let GC take care of the presenter. Also fix #947
- Kotlin 1.1.4. Add discord link in about
- README, CONTRIBUTING and ISSUE_TEMPLATE, Discord
- License manga update and Manga Fox Title Update
- Revert chapter equals method
- Allow to update chapter metadata
- Also fix Batoto popular query
- Batoto fix. #953
- Minor changes
- Ask permissions once. Fixes #892
- Fallback chapter cache to internal storage
- Crop borders for webtoons. Closes #904
- Simultaneous download will now show on start.

### Fixed
- Fix a crash when retrying pages
- Fix tint on AMOLED theme
- Fix #956
- Fix most crashes with extensions and the release version. Crop borders support in android O
- Fixes case where manga name ends with s.
- Fix library category not updatable when empty. Closes #907

### Removed
- Remove circle image view dependency

## [0.6.1] - 2017-07-08

### Changed
- Release 0.6.1
- Downgrade jsoup

## [0.6.0] - 2017-07-08

### Added
- Add option to invert volume keys. Closes #834
- Add landscape layout for manga info. Fix portrait layout image paddings when the tab layout was expanded
- Add an option to refresh all tracking metadata
- Add images and 'view chapters' to library updates

### Changed
- Release 0.6.0
- Dependency updates. Enable new translations. Minor fixes
- New translation system
- Fallback batoto urls to http (a library update took ages). Kotlin update to 1.1.3
- Main activity now uses single task. Fixes #850. Actually use new support library
- Library notification now opens recent updates. Closes #808
- Allow sorting by total chapters for library view
- Russian strings update
- Reorganize layouts by feature
- Dependency updates. OkHttp nullability changes
- Downloads with conductor. Remove flexible adapter 4 dependency and unused classes.
- Minor changes to tabs animator
- Use an object animator for the tabs
- Replace changelog dialog with controller, move migration logic to a separate class
- Improve tab layout animation. Fixes #800 and #801
- Info shows last chapter instead of chapter count. Resolves #765
- Preferences with conductor
- Recent chapters with constraint layout
- Initial AMOLED theme + some CardView fixes
- UI with Conductor
- Replace media_id with manga_id
- Deleting categories hides manga until switch from and to library #686
- Allow multiple sources in each extension source apk
- Pass backup uri as parcelable to restore service
- Keep models from source package

### Fixed
- Fix gradle build warnings. Remove unused strings
- Fix #880. Downgrade conductor to 2.1.2 for now
- Fix issues with Batoto; some links now use https rather than http, so parsing was affected.
- Fix local source not working if english was disabled. Closes #848
- Fix #819. Update support lib
- Fix backup issue. Closes #806
- Fix memory leak
- Fixed tracking cardview + readded AMOLED theme.
- Fix settings crashes before Lollipop
- Fix webtoon scroll jumps. Closes #751

### Removed
- Remove activity mixin class
- Remove unused classes and arrays resources
- Remove limit from query

## [0.5.2] - 2017-04-14

### Added
- Add manga straight into a category from catalogues
- Added round icon + added shortcuts
- Add short description to library update notification

### Changed
- Release 0.5.2
- Dependency updates
- Improve webtoon reader scroll up
- Retain last read page when using the webtoon mode
- Use new rating system. Fixes #743
- Small fixes
- Notify licensed content in mangahere
- Rewrote Backup
- Library notification: handle only one update as a special case
- Cancel library progress notification after posting the result
- Update app icon with shadow
- Separate some changes unrelated to backup from PR
- Keep new chapters notification across updates

### Fixed
- Fix shortcuts
- Fix #708
- Fix activity leaks in backup, restore dialogs and properly handle db transactions
- Fix #716

## [0.5.1] - 2017-03-19

### Added
- Add dev flavor. Bugfix in reader

### Changed
- Release 0.5.1
- Update vietnamese strings. Document Kissmanga changes
- Category-specific auto download
- Kissmanga fix. Kotlin 1.1.1
- Prevent some manga breaking the download notifier
- Manga info with constraint layout
- Update chapters adapter
- Post updater notification before starting downloads
- Don't post too many notifications in the updater
- Handle a few more possible external directories before Lollipop
- Minor changes for Kotlin 1.1
- AS 2.3 and Kotlin 1.1

### Fixed
- Fix #704. Dependency updates
- Fix #692. Mangasee needs proper headers for data requests.

## [0.5.0] - 2017-02-26

### Added
- Add crop borders functionality, #219
- Added translatable="false" to keys so that they don't show up as untranslated
- Add bulgarian language #644
- Add Sort filter [Catalogs]
- Added Russian language
- Added add to library dialog when downloading from catalogue
- Added circular thumbnails to the catalogue list view, like the ones in the library list view

### Changed
- Release v0.5.0
- Minor fixes and improvements. Dependency updates. Drop support for the old armeabi and use arm64-v8a instead
- Borders crop improvements
- Chapter Recognition for Read/Mintmanga
- Update CONTRIBUTING.md
- Rar/cbr support
- Basic epub support
- Error drawable now looks better with the dark theme
- Show loading/error for images in catalogue grid view. Update support lib
- Allow glide to use source's network client. Catalogue fixes
- Improve local manga chapter sorting
- Ask for chapter deletion when removing from library
- Use the first 3 bytes for jpeg
- Use custom mime discovery in downloader
- Language hot fix
- Enable Vietnamese language
- Update Vietnamese Language
- Update subsampling
- Local chapter url relative. Other minor changes
- Local manga in zip/cbz/folder format
- Migrate covers to external files dir. Fix #647
- Bulgarian translation typos and fixes for better understanding
- Disable elevation in recent chapters. Improve downloads discovery
- Update recent chapters adapter
- Catalogue fixes
- Update extension loader
- Optimize imports
- Rename OnlineSource to HttpSource
- Move source and network outside data
- Optimize imports
- Notification Improvements
- French language
- Update subsampling with some fixes
- Dependency updates
- Rewrite catalogue adapter
- Catalogue with only one recycler
- Complete group filters
- Minor changes
- Filters with flexible adapter
- Update category adapter
- Change package name to flexible adapter v4
- Include manga instead of media
- Merge and remove util classes
- Initial support for external sources
- Also filter included by manga
- Filter manga library entries in Kitsu
- Replace bad image url with the logo in mangafox. Related with #626
- Set IME action done
- README.md table update
- Change filters dialog with a drawer
- Improve catalog search filters
- Now using subsampling 3.6.0

### Fixed
- Fix #636. Minor improvements. Dependency updates
- Fix #660. Update subsampling
- Fixed multi-threaded initial download not showing.
- Fix FAB behavior
- Fix Mangachan issue from #628
- Fix #661
- Fix sticky headers in recent chapters not working after rotation
- Fix filter input text introducing a new line. Also fix filter drawer clicks propagated to the views below
- Fix Rapid region decoder
- Fixed a typo in an Italian string
- Fix #620

### Removed
- Remove custom presenter class
- Remove unused resources

## [0.4.2] - 2017-01-01

### Added
- Add "Completed" filter; fix Mangahere; fix Mangafox

### Changed
- Release 0.4.2
- Minor changes
- Locale fix. Kotlin update to 1.0.6
- Make clear error codes are from HTTP
- Minor changes
- Kitsu fixes
- Translated some strings to Italian
- Exclude novels from Kitsu results
- Anilist/Kitsu Fixes
- Refresh option in the library updates tab
- Drawerfix/readme update
- Show login errors
- Minor changes
- Hide API implementation from MAL service. Reorder methods and minor changes
- Score formatting. Hide API from Anilist/Kitsu services.
- Using title instead of text for Mangahere titles
- Dependency updates
- Experimental Anilist and Kitsu support

### Fixed
- Fix #373 and a few crashes
- Fix locale not applied outside activities
- Fix Kitsu refresh method
- Fix wrong anilist decimal scores
- Fix system language setting always using english
- Fixed updater on Android N. Closes #592
- Fix tab gravity
- Fix #587

### Removed
- Remove Language class. App's language and hidden languages settings were reset

## [0.4.1] - 2016-12-18

### Added
- Add ripple effect to filter nav view
- Add unread sorting
- Add drawer to filter and sort the library
- Add optional to automatically download new chapers
- Added option to sort library

### Changed
- Release 0.4.1
- Bugfixes
- Apply material design guidelines to categories
- Library sort change doesn't trigger filtering
- Improved last_read sorting
- Format fixes. Move lang setting to the first entry (looks better IMO)
- Implement language switcher
- Better network error handling
- Optimize library downloaded filter
- Ask for confirmation before changing the cover. Fixes #562
- Readers know how to move to each side. Fix #566
- Handle null directories as empty arrays
- Improve download discovery performance in library updates view
- Avoid going to db when a library filter is changed

### Fixed
- Fix method conflicts
- Fixes wrong getBroadcast calls from imageNotification
- Fix #577. Fix language not applied in reader activity.
- Fix webtoon reader touch events. #561

### Removed
- Remove some state from the library view

## [0.4.0] - 2016-12-03

### Added
- Add property to get the number of a page
- Added Volume and Title to chapters from MangaHere
- Add an extension function to limit the number of characters in a string. Dependency updates
- Added option to download page or set page as cover
- Added page.ready check
- Added code to prevent OutOfMemory error.  Made notification optional. Can now save image on long press. Bug fixes
- Added option to download page or set page as cover
- Add product flavors. Switch to evernote's job scheduler
- Added option to bookmark single chapter
- Support API 25 again. Bump dependencies
- Add support for latest updates to Readmangatoday

### Changed
- Release 0.4.0
- Image is now the default decoder
- Minor changes and fixes
- Download next N chapters now excludes the ones enqueued. #556
- Don't allow to create categories with the same name
- Upgrade okhttp
- Italian language
- Allow to share images when reading online. Move chapter cache to external cache dir. Dependency updates.
- Update subsampling
- Update preferences lib
- Set share image mimetype with wildcard
- Don't validate the page number and extension when saving a page
- Always cancel library update task
- Minor refactor
- Handle empty directory. Fix travis
- Dependency updates. Remove some unused strings
- Improve extension discovery. Fix #542
- Some improvements for russian catalogs
- Better recent updates regexp for Mangasee
- Download manager rewrite
- Minor fix
- Trying to fix a crash in settings (again)
- #529
- Trying to fix a crash in settings
- Merge pull request #526 from Gilfar/mangasee-seasonal
- Update for seasonal manga from Mangasee
- Indention
- Now uses glide for notification
- Format fix + notification feedback
- Changed sort icon from by alpha to by numeric
- Update Mangasee due to webpage changes
- Allow to change chapter fields before inserting to database. Update Kotlin to 1.0.5
- Update MangaSee URL
- Set flex time
- Rename bookmark column val
- Exclude backup empty fields
- Update travis

### Fixed
- Fix #547
- Fix #528
- Fix #546
- Fix #545
- Fix #541
- Fix #517 and a few more crashes
- Fixed API 24 FileProvider error
- Fixes
- Fixes + API 16 support
- Fixed webtoon page
- Fix compilation error
- Fix update notification not allowing installations on some ROMs (like MIUI)
- Fix travis
- Fix tests

### Removed
- Removed network call now copies from page image

## [0.3.2] - 2016-10-30

### Added
- Added another image decoder. It should be faster than Rapid and more reliable than Skia.
- Support API 25. Use new DividerItemDecoration.

### Changed
- Release 0.3.2
- Reader fixes
- Change webtoon image callback to onReady
- Minor changes
- Webtoon reader now shows download progress. Keep the progress bar until the image is decoded
- Drop support for reencode images
- Revert support lib 25 (broken as usual), update subsampling lib
- Revert "Support API 25. Use new DividerItemDecoration."

### Fixed
- Fixed wrong chapter recognition for S0 - Chapter 00

### Removed
- Remove builtin decoders from Rapid
- Remove 2048 bitmap size limit

## [0.3.1] - 2016-10-17

### Changed
- Release 0.3.1
- Keep project classes

## [0.3.0] - 2016-10-16

### Added
- Add app's notification icon
- Add simple method for preference bindings
- Added option to share your favorite manga
- Added read filter to chapter select.
- Add filter support to readmangatoday
- Add filter support to mangasee
- Add filter support to mangahere
- Add genre filter for catalogue
- Added the ability to view the library as a list

### Changed
- Release 0.3.0
- Minor changes
- Decode notification logo in background thread. Set max bitmap size to 2048
- Another crash fixed in webtoon reader
- Use old refresh icon (but with the app's logo)
- Multidex debug build
- Update GCM
- Dependency udpates, ABI filters
- Delete old alarm
- Update Portuguese(pt_PT) translation.
- Oops.. Fix #489
- Handle individual errors in metadata update
- Increase minimum tile dpi
- More crash fixes
- Crash fix
- Update metadata now ignores only completed manga setting
- Ignore chapters with duplicated name. Fixes #483
- Allow to refresh the entire library info (fixing empty covers after restoring backups). Closes #462
- Explicitly remove read phone permission
- Download queue will now be reset if negative.
- Keep compatibility with YAML sources. Reorder methods
- Implement latest updates.
- Bump dependencies, remove unused resources
- Open from homescreen/add shortcut to launcher
- Gradle custom script 'app/custom.gradle'
- Update kotlin and gradle build tools
- Custom color filter for reader
- Hide catalogues
- Merge anilist backend
- Place restrictions above category selection
- Show default message when no categories selected
- Ignore a random crash when closing the reader
- Select categories for global update
- Notify first page change
- Parse manga from the future
- Upgrade dependencies, use new Timber's overloaded method for errors
- Complete auto updates checker
- Minor UI fixes
- Improve performance with big images. Feedback is appreciated.
- Merge pull request #441 from icewind1991/more-eng-filter
- Travis fix. Update gradle
- Merge pull request #438 from Taumer/ru_parsers_genre_filter
- Implement genre filter for Readmanga
- Implement genre filter for Mintmanga
- MAL switched to SSL/HTTPS
- Update Mangasee chapter selector
- Rename fragment to view
- Library views recycling
- Disable shared holders for now
- Dynamic recyclerview inflation for the library view and better swap handling
- Recycle view holders in library. Format fixes
- Set jdk 8 in travis
- Update travis
- Bump dependencies, set target sdk 24
- Replace page fragments with views
- Minor Improvements

### Fixed
- Fixed incorrect string for color filter
- Fix tests
- Fix #480 ?
- Fix library update interval not being updated properly
- Fix broken link
- Fix #446
- Fix crashes introduced yesterday
- Fix text overlapping, make icons a bit bigger
- Fix inverted if condition
- Fix #408
- Fix robolectric tests

### Removed
- Remove unused context from sources
- Remove unneeded call
- Remove debug log

## [0.2.3] - 2016-07-24

### Added
- Added a startup screen preference option
- Add an overlay on top of the reader to simulate a lower brightness. Closes #362
- Add icons for settings
- Add portuguese translation by @MrAmnesiac
- Add chapter loader, drop non seamless mode
- Added recently read tab

### Changed
- Release v0.2.3
- Update history custom put resolver
- Back button now returns to start screen. Also fix #356
- Minor fix
- Observable calls can now be retried, previously all retries were failing
- And a few more crashes fixed in preferences
- Minor changes
- Recently read improvements: Open next chapter if read, local date formatting
- Minor changes
- Implement "Wie Manga!"
- Downloads view now uses a copy of the original queue. Fixes #351 and some crashes while scrolling and removing a download from the queue
- Bump dependencies
- Ignore the first spinner selection
- Spanish UI translation
- Cleanup - squid:S1155 - Collection.isEmpty() should be used to test for emptiness
- New reader menu
- Handle a missing page list in MangaHere
- Reader fixes (MAL not updating in certain scenarios)
- Use Cloudflare client for ReadManga.Today
- Mangasee as image source
- Parser improvements
- Rewrite preferences with a modified support library v7
- Restart inject module when the app is created
- Convert some classes to Kotlin
- Bump dependencies
- Test package in Kotlin
- Merge pull request #350 from inorichi/dev
- Replace Dagger2 with Injekt, reorganize dependencies
- Rewrite database models in Kotlin
- Update Mangachan address and fix loading covers after update
- Update readme
- Match release version
- Improve regex for pages from Readmanga and Mintmanga
- Delete file when exception is thrown
- Cloudflare fix. Closes #344
- Multiple quality improvements - squid:S1213, squid:S1943, squid:S1066
- Use cardBackgroundColor instead of android:Background
- Small card fixes
- Wrong card background fix + bump gradle version
- Improve getAbsolutUrl method
- Manual mappings. Code generation on java classes (better compilation times)

### Fixed
- Fix #400
- Fix exception thrown when Batoto search is empty
- Fix #361
- Fix for #361?
- Fix YAML parser crashing the app on Kitkat and lower
- Fix a few crashes
- Fix #333
- Fix chapters with 1 page not marked as read
- Fix tests
- Fix dependency injection and use custom models extending DB ones
- Fix scroll position with many categories. Closes #332

### Removed
- Remove deprecated calls and fix a potential race condition
- Remove most unused settings from the reader (keep screen on and page transitions), they are still available in the app's settings. Also lower minimum brightness to -75%
- Remove newThread usages, it probably fixes random crashes
- Remove no predictive animations. Upgrade Kotlin to 1.0.3
- Remove getAbsoluteUrl method
- Remove unneeded annotations and some cleanup
- Remove covers on error. #334
- Remove unneeded casts

## [0.2.2] - 2016-06-06

### Added
- Added improvements for RecentChapters. Closes #320
- Added chapter recognition for "season" case
- Add support's library  custom tabs
- Add confirm dialog for multiple deletion. Closes #155
- Added download notifications, resolves #260
- Add an option to reencode images under the advanced tab. #262

### Changed
- Release 0.2.2
- Minor changes
- Minor improvements
- Better error feedback. Closes #325
- Make active page nullable. Fixes #326
- Merge pull request #323 from NoodleMage/season
- Rename "Only update incomplete manga" string to "ongoing"
- Reader fixes and minor changes
- Minor improvements for sync services
- Chapters FAB doesn't depend on the recognized chapter number. Cloudflare resolver fix
- LoginSource moved to an interface
- Downloading chapters now always add them from the beginning
- Default headers are bad
- All network calls are now done directly through the client
- Use async method for network calls, trying to fix a crash
- Minor classes restructuration and optimize imports
- Minor fixes
- Do not parse -2 chapter number
- Always close requests' response body
- Merge pull request #239 from inorichi/rewrite-source
- Change default sorting method
- Show changelog when new version is installed
- Implement ReadMangaToday with the new source
- Reimplement russian sources
- Implement Mangafox and Mangahere with the new source
- Rewrite sources. Implement Batoto and Kissmanga
- Wrong versionName when not building latest version
- SwitchLastCaseIsDefaultCheck - switch statements should end with a default clause
- Exclude manga from unknown sources from the library
- Load next/prev chapter depending on the sorting method
- Allow to change sorting mode from the chapters fragment
- Tables classes in Kotlin. Rename COLUMN -> COL
- Database support for ordering chapters like the source
- Merge pull request #303 from NoodleMage/myanimelist_cardview
- Make status bar transparent on API >= 21
- UI tweaks
- UseIndexOfChar - Use Index Of Char
- Optimize imports
- Kissmanga loading through Cloudflare. A lot of refactoring was needed
- Bump dependencies and support library
- Double the distance required to trigger category update and remove overflow menu setting
- Rewrote ChapterRecognition to Kotlin.
- Build debug in travis
- Change travis gradle task, small doc update
- Trying workaround for #296
- Category update can only be triggered when the list is at the top
- Remember last active category. Closes #261
- Swipe down updates active category. Closes #292. Not sure I'll keep this
- Allow to open manga in the browser. Closes #157 (Doesn't work with kissmanga)
- Minor changes
- Delete from the download queue on the main thread. It could fix some crashes
- Allow to update one category
- Database queries are now separated by table. Improve how the app creates downloads
- Toggle reader menu with the menu button, closes #286. Fix incorrect drawer selected item when using back button
- Downgrade RxJava. Closes #285
- Bump dependencies
- Refactor and convert to Kotlin base classes. Fix FAB behavior
- Release version manual update hotfix.
- ImmutableField - Immutable Field
- S1118 - Utility classes should not have public constructors
- Auto number of latest release, shorter versionCode
- S2039 - Member variable visibility should be specified
- Release 0.2.1
- Make query non nullable, it fixes some bugs in the catalogue
- Merge pull request #257 from NoodleMage/update_improv
- Rewrote UpdateDownloader to Kotlin
- Use a thread-safe list for downloads
- Minor changes to fix a possible crash in the downloads view
- Allow setting versionCode in parameter
- Slightly increase library view performance by caching typefaces
- Upgrade to nucleus 3
- Back button now returns to library. Closes #252
- Downloads now retry requests after some seconds. Closes #271
- Minor changes
- Oops... nobody noticed being unlogged from batoto?
- Release resources before trying to delete an incomplete file #264 #211
- Revert "Temporarily include nucleus in the project"
- Always close response body
- Temporarily include nucleus in the project
- Also use manga per row setting in catalogue
- Allow to unbind manga, closes #258. Fix some network calls leaking
- Mark common categories when moving them. Closes #135
- Rewrite PreferencesHelper.  Allow to customize navigation with volume keys and tapping. Closes #251 and closes #129.
- S1854 - Dead stores should be removed

### Fixed
- Fix #329. Add confirmation before removing favorite manga on multiple selection. Add new proguard rules
- Fix #328
- Fix network unsubscription crashes, refactor network methods
- Fixed spinner + improved ripple
- Fix an issue with seamless mode and chapters with less than 5 pages #291
- Fix MAL not binding a manga. Upgrade Kotlin to 1.0.2
- Fix a crash when trying to change the downloads directory on some devices
- Fix #267
- Fix a crash when updating active category and no categories available
- Fix catalog covers' flickering when adding a page
- Fix recent chapters menu button not showing on high dpi screens
- Fix F-Droid not recognizing update
- Fix recent crashes
- Fixed some crashes in the catalogue and the reader
- Fix a crash in older android versions
- Fix #277, library not updating
- Fix incomplete downloads. Closes #264
- Fix custom brightness turning off the screen. #106
- Fixed backup/restore for 3rd party applications

### Removed
- Remove unneeded swipe refresh
- Remove RelativeLayout from covers for better performance
- Removed automatic update + duplicate fix

## [0.2.0] - 2016-04-17

### Added
- Added option to check if connected to power before updating. closes #192
- Add presenter subscriptions to the subscription list when using custom subscribe methods
- Add caching to travis
- Add commit number to version name in debug version
- Support backups
- Added animation
- Support for sources from different languages
- Add link to wiki about debug F-Droid

### Changed
- Update readme
- Release 0.2.0
- Also use no predictive animations for AutofitRecyclerView
- Use always 3 characters for downloaded pages. Fixes #181
- Some bugfixes
- Skip memory cache for images in catalog
- Not yet #187
- Minor XML refactoring
- Bump subsampling version
- Changes in cover cache. Store covers in external cache dir
- Style toolbar's spinner with light theme
- Hide upload date if not parsed
- Light and dark theme are now using different accent colors
- Dark theme now uses accent color for drawer items. #222
- Make status bar transparent on API > 21 properly. Snack function moved to an extension method in View
- Merge pull request #245 from j2ghz/patch-1
- Move modified dependencies to another repository. Reorganize dependencies
- Merge pull request #244 from j2ghz/master
- Rearrange badges on README
- Try https://github.com/travis-ci/travis-ci/issues/4185
- Upgrade buildToolsVersion for SubsamplingScaleImageView
- Travis
- A few more crashes fixed
- Upgrade support library. Switch gradle build tools and AS to 2.0. Adapt code to new support lib
- A few more crashes fixed
- Minor changes trying to fix a crash
- Minor changes. Also fix #240
- More crash fixes
- Crash fixes
- Merge pull request #238 from j2ghz/patch-1
- Upgrade dependencies. Downgrade material dialogs to avoid crash on older android versions
- Minor UI fixes
- Merge pull request #212 from inorichi/backup
- Merge pull request #234 from NoodleMage/sort
- Try with a bigger heap to avoid OOM crashes
- Merge pull request #227 from NoodleMage/issue_42
- Can now choose to automatically remove chapter after reading (or previous). Fix #42
- Implements delete chapter when set as read for issue #42
- Implements  Download next 1/5/10/all chapters for issue #42
- Merge pull request #225 from NoodleMage/manga_chapters
- Changed fragment_manga_chapters.xml. Fix #221
- Merge pull request #201 from na-ji/master
- Merge remote-tracking branch 'upstream/master'
- Page number indicator now transparent
- A few crashes fixed
- Implement #226
- Downgrade RxJava for a while
- Minor changes
- Use kapt, remove retrolambda, migrate database and source to Kotlin
- Reader presenter in Kotlin + remove Icepick
- All events in Kotlin
- Download manager in Kotlin and fix another crash in reader
- Raw queries in Kotlin
- Reader view in Kotlin. Upgrade gradle wrapper. Remove ButterKnife from the project
- Bump dependencies. Fix crash in reader
- Merge pull request #218 from NoodleMage/theme_update
- Rewrote Theme
- Rewrote nav drawer to Kotlin + UI updates
- Different approach for #214
- Manga in Kotlin. Expect some errors yet
- Merge pull request #171 from Taumer/ru_parsers
- Implement parsers for Readmanga, Mintmanga and Mangachan
- Merge pull request #209 from inorichi/source-languages
- Kotlinize some widgets
- Merge pull request #204 from NoodleMage/svg_all_the_way
- Converted all icon drawables to vector.
- Preferences ported to support library
- Merge pull request #198 from NoodleMage/issue_27
- Performance improvements for library filters
- Can now filter unread manga + Code opt
- Can now filter downloads only on library view. Fix #27
- Allow to cancel update. #192. Needs testing
- Merge pull request #202 from beschoenen/patch-1
- Hide clear button
- Replace some image drawables with vector drawables
- Merge pull request #199 from j2ghz/patch-1
- Update ISSUE_TEMPLATE.md
- Readers in Kotlin. Also fix #193
- Some base classes and preferences in Kotlin
- Merge pull request #190 from NoodleMage/kotlin
- Rewrote Recent to Kotlin
- Readded chapters do not notify. Fix #188
- Catalogue in Kotlin. Support library upgraded to 23.2.0. Downloads directory now shows a list of folders, it should fix #141.
- Settings in Kotlin
- Merge pull request #183 from NoodleMage/master
- Rewrote IOHandler to Kotlin
- Allow custom parsing of chapter number on sources
- Download queue's UI in Kotlin
- Bump dependencies. Move ReactiveNetwork to app module.
- Log message error when a request from the catalogue fails.
- Refresh adapter after the cover is changed. Some minor changes on categories.
- Merge pull request #182 from NoodleMage/cover_edit_fix
- Cover change fix (hopefully :-)
- Merge pull request #180 from inorichi/library-kotlin
- Migrate library to Kotlin.
- Merge pull request #178 from NoodleMage/kotlin
- - Rewrote Category to Kotlin
- Rewrote ScrollAwareFABBehavior.java to Kotlin. Can now implement FABAnimationBase to create different FAB animations
- Allow to retry image when decoding fails or open in the browser. Fixes #177 and fixes #120. Also fix a bug where the current page was not restored when changing settings.
- Probable fix for #168. Maybe #81 also. Needs confirmation.
- Merge pull request #175 from j2ghz/patch-1
- Delete an old file
- Merge pull request #169 from inorichi/kotlin
- Partial migration of data package to Kotlin

### Fixed
- Fix a crash on older devices
- Fix some crashes when restoring backups
- Fix for #187?
- Fix scrolling issue
- Fix #248
- Fix last commit
- Fix for #144?
- Fix #242. Minor changes
- Fix proguard rules
- Fix a bug when opening a chapter from the recents tab and changing the viewer from the reader would not update chapters for that manga anymore
- Fix formatting issues when people ignore instructions
- Fix an error when restoring backup
- Fix #236
- Fix a crash in the reader when restoring the instance. Removed capitalization on each word
- Fix #99
- Fix crashes on settings
- Fix last commit
- Fix directory picker
- Fix a query
- Fix tests
- Fix crashes
- Fix last commit
- Fix ACRA not attaching BuildConfig
- Fix reader theme
- Fix login dialogs not showing the correct title
- Fix #206
- Fix crashes with vector drawables on older Android versions
- Fixed wrong download filter from commit #33386e2
- Fix #196
- Fix possible crashes similar to #191
- Fix #191
- Fix builds
- Fix broken tests after last commit
- Fix #179
- Fix #168 and fix #81.
- Fix tests after Kotlin merge (probably)

### Removed
- Remove gradle properties and fix travis build
- Remove unused strings
- Remove unused attrs and colors. Theme preference dialogs on API >= 21
- Remove unneeded repository
- Remove unneded dependency
- Remove unneeded class
- Remove lambdas
- Remove apt, add manual EventBusIndex (not sure if it works)
- Remove problematic test

## [0.1.4] - 2016-02-21

### Added
- Add library search. Closes #64

### Changed
- Release 0.1.4
- Merge pull request #167 from j2ghz/patch-1
- Merge pull request #164 from j2ghz/patch-1
- Move github files to .github/
- Create ISSUE_TEMPLATE.md
- Merge pull request #160 from NoodleMage/issue_118
- Code cleanup, implements #118
- Can now mark as read / unread
- Can now delete manga from recent + added missing res files #118
- Can now download from recent tab. #118
- Merge pull request #152 from icewind1991/chapter-parsing
- Prefer numbers at the start of the chapter title if otherwise unparsed
- Improve colon handling
- Always create nomedia file
- Merge pull request #150 from NoodleMage/comments
- Improved comments
- Merge pull request #151 from icewind1991/chapter-recognition-fallback
- Possible fix for #120
- Merge pull request #143 from NoodleMage/fab_improvement
- Moved edit cover to library | Updated manga info view | Updated catalogue
- Show keep screen on in reader settings. Closes #146
- Incorrect mark as read with seamless mode. #142
- Merge pull request #139 from j2ghz/patch-1
- Update README.md
- Merge pull request #137 from NoodleMage/fab_improvement
- FAB animation update
- Merge pull request #136 from icewind1991/search-sort
- Sort by views for mangafox and mangahere search results
- Allow to force a rotation
- Strip html tags from batoto notice and directly throw an exception
- Merge pull request #132 from icewind1991/batato-staff-notice
- Show batoto staff notice if updating chapters failed
- Include reactive network as library
- Trying to give write permissions on SD card
- Increase maximum allowed scale on pagers
- Volume keys scroll pages. Closes #95
- Merge pull request #130 from icewind1991/chapter-number-parsing
- Handle chapters with part numbers
- Fallback to parsing parts to handle arc numbers
- Differentiate subchapters denoted by an alpha prefix
- Prefer numbers without anything appended when parsing chapter numbers
- Handle chapter versions which are attached to the chapter number
- Upgrade to EventBus 3
- Merge pull request #126 from beschoenen/downloading
- Move clear queue to presenter
- Set display mode title
- Cleanup chapter action menu
- Clear the download queue
- Change stop to pause in download queue view
- Multiple chapter download from manga view
- Use a shorter description for seamless mode
- Merge pull request #112 from icewind1991/seamless-chapters
- Seamless chapter transitions
- Upgrade dependencies
- Cancel notification when no new chapters are found. Closes #121
- Remember last used source. Closes #30
- Upgrade gradle. Other minor changes
- Try to mark readded chapters as read. #119
- Use network cache
- Trying to fix a backpressure isue
- Minor changes
- Implement zoom start position. Closes #92. Rapid decoder properly throws an error when it fails to decode.
- Download the first image of the next chapter
- Replace onProcessRestart with the new startables.
- Merge pull request #98 from NoodleMage/download_updates
- Application can now check if update available
- Display date in local format. Fix #108
- Update readme

### Fixed
- Fix link broken by PR #164
- Fix crash in chapters list #159
- Fix infinite loop when no chapter number is parsed
- Fix tests failing after upgrading EventBus
- Fix a crash

### Removed
- Remove old orientation lock. Add orientation types to preferences
- Remove unneeded dependency.

## [0.1.3] - 2016-02-03

### Added
- Add smart fit. Closes #85
- Added icons to navigation drawer. #47
- Add a way to search in MAL only from the user's list
- Add F-Droid badge
- Add an alternative way to display the chapter title

### Changed
- Release 0.1.3
- Show brigthness preference in reader settings. #106
- Use Rapid only for regions. Fixes #97 (probably)
- Ask for external storage permissions on Marshmallow. Fixes #76 and #36
- Webtoon reader "restores" position on rotation. Fixes #93
- Now tap on edges of webtoon reader scrolls by 3/4 screen
- Merge pull request #86 from j2ghz/patch-1
- Create CONTRIBUTING.md
- Merge pull request #90 from cyalins/patch-1
- Update strings.xml
- Reworded and shortened some strings
- Use Rapid decoder also when no regions are required
- Merge pull request #94 from NoodleMage/local_cover_small_fix
- Manga initialized check. Now takes network cover image if something went
- Minor changes
- Merge pull request #91 from NoodleMage/change_cover
- Can now manually set cover pictures. #79
- All chapter filters are now saved
- Avoid OutOfMemory crashes on webtoon viewer increasing view holders height
- Trying improvements for webtoon viewer. #71
- Upgrade OkHttp to 3.0.1
- Merge pull request #82 from cyalins/master
- Changed the wording on some strings
- Minor refactor on caches
- Let Glide cache local covers, it improves performance loading the covers from the library
- Merge pull request #77 from NoodleMage/material_nav
- Format fixes
- Merge pull request #78 from NoodleMage/upstream
- Code optimization. Added javadoc. Removed setSize for it is not used
- Initial support for custom images scaling
- Trying to fix some crashes
- Reorganize readme
- Update readme

### Fixed
- Fix #100
- Fix gestures on vertical readers

## [0.1.2] - 2016-01-25

### Added
- Add backpressure buffer for downloads

### Changed
- Don't lint release builds
- Update readme
- Release 0.1.2
- Make toolbar always visible
- Minor changes
- Merge pull request #69 from icewind1991/info-show-source
- Show manga source in info panel
- Use a gradient at the bottom of the cover. Remove external repositories from gradle
- Place reload button above the image
- Merge pull request #57 from icewind1991/chapter-list-ellipsize
- Elipsize chapter list in the middle
- Merge pull request #53 from icewind1991/sort-order
- Save per-manga sort order
- Merge pull request #51 from icewind1991/last-page
- Load the last page when switching to the previous chapter
- Change filename for downloaded chapters, using the last path from the url is not reliable. This will break compatibility with previously downloaded chapters, they have to be deleted and downloaded again.
- Hold the same manga instance (allowing to refresh manga state from the catalogue). Other minor changes.
- Allow to display manga from catalogue as a simple list
- Trying switches instead of checkboxes
- Improve recent chapters layout
- Change recent chapters query, now it shows last month updates. Download manager now uses a thread pool.
- Tint navigation bar on Lollipop and higher
- Reenable recent updates tab
- Change toolbar color . Allow to also remove from library . Rewrite RxPager.
- Update readme

### Fixed
- Fix layout overlapping
- Fix #58 and #59
- Fix number of simultaneous downloads ignored (again)
- Fix #52
- Fix an UI refresh issue

## [0.1.1] - 2016-01-20

### Changed
- Allow to mark all previous chapters as read
- Upgrade StorIO to 1.8.0
- Show only recent chapters of the library
- Don't reset library adapter if it's not needed
- Sort sources alphabetically. Fix #31
- Initial support for recent updates. #20
- Merge pull request #33 from wopian/patch-2
- Update README.md
- Merge pull request #32 from wopian/patch-1
- Allow to add a manga to the library with a long click
- Update readme
- Prepare for dev releases
- Update readme

### Fixed
- Fix a big issue with the download threads. Release 0.1.1
- Fix #39
- Fix an error with empty pages from downloaded chapters (images not found)
- Fix some grammatical issues

## [0.1.0] - 2016-01-16

### Added
- Adding a new logo, finally! Thanks @LinkCable
- Add an option to allow downloads on mobile connections.
- Add an option to automatically update last chapter read and another one to ask before updating. Fixes #10
- Add an option to update the library automatically after a specified time and an option to update only non completed mangas. Other minor changes.
- Add Rapid decoder for better image support. Reorganize readers.
- Add minor improvements and retry button to webtoon reader.
- Add buttons to open next/previous chapter in the reader. Try entire app with hardware acceleration
- Add a new test case for chapter recognition
- Add a black background setting for the reader
- Add sdk manager to gradle
- Add an option to change cache size and clear the cache
- Add an observable that notifies of every download progress
- Add filter by downloaded chapter. When searching manga by URL, also check the source
- Add a query to get the next unread chapter
- Add Kissmanga (search not working yet)
- Support Batoto webtoons
- Add an option to use custom brightness
- Add a subscription to the list
- Add more settings to the reader
- Add an initial menu for the reader, and some minor changes.
- Add a temporary way to select download directory
- Add multiple chapters selection and allow to mark them as read/unread
- Add vertical viewer. Allow to select a viewer
- Add broken webtoon viewer (not sure if it will be possible with RecyclerView)
- Add MangaDetailActivity with two fragments, info and chapters
- Add catalogue detail page. Add simple tests for sources
- Add MangaHere source
- Add proguard rules. Show unread count. Use compact font
- Add composite subscriptions
- Add an option to get unread chapters of mangas
- Add library class

### Changed
- Update readme
- Bump dependencies. Minor changes to download manager
- Prepare for first release
- Rename project
- Open app from the new chapters found notification. Fixes #22
- Do not let the launcher create a new MainActivity
- Hide the search button in the library until it's fixed (or removed)
- Exclude novels from MAL. Fix #19
- Improve chapter recognition.
- Crash fixes
- Minor changes
- Allow whitespaces in downloads path and add chapter id to avoid path conflicts. Throw if page list is empty
- Rewrite the chapter insertion method. Create a wakelock until the library updates. Move custom preferences to widget package.
- Don't update the chapter list if the parsed list is empty
- Notify when an image can't be decoded in the pager reader. Changes to theme. Reload library adapter when the mangas per row setting is changed (to recalculate covers height).
- Show selected decoder and background color in the popup menu. Reload adapter when the decoder changes.
- Keep covers aspect ratio. Unsubscribe from the library when it's not needed.
- Drop progress emissions on backpressure
- Replace hamcrest with assertj. ChaptersSubject now uses only one observeOn.
- Trying to fix a backpressure issue .
- Use ARGB8888 for covers. Fix buttons background
- Theme fixes
- Enable tiling to webtoon reader and add a fade in animation
- Improve webtoon reader precaching images. Show a badge for the apk.
- Update readme
- Rename viewpager classes
- Host readers inside a fragment (Avoids some leaks)
- Make all info fragment content scrollable
- Description scrollable and show real manga status.
- Use RecyclerView for catalogue
- Merge pull request #12 from j2ghz/master
- Make gradlew executable
- Create an util class to write less code on sources. Save status from sources.
- Allow to refresh data from MAL and show total chapters. Create nomedia file for default downloads folder on new installations.
- Store total chapters from MAL and automatically set as completed  if it's the last chapter. Other minor changes
- Minor changes
- Category improvements
- Upgrade storio to 1.7.0
- Hide default category if it doesn't have any manga
- Change mangas from categories (needs testing)
- Allow to reorder and rename categories
- Allow to create/remove categories. Some refactoring.
- Allow to change number of columns
- Use recyclerview in library
- Categories improvements
- Incomplete changes
- Minor changes
- Initial commit for categories
- Include Subsampling Scale Image View as library to allow preloading tiles when a max bitmap size is provided.
- Merge changes from Nucleus presenter
- Allow to set status, score and last chapter read in MAL. Other minor changes
- Make sure the answer from MAL is successful before updating DB.
- Allow to start/stop queue from download queue fragment. DownloadQueue now extends from ArrayList.
- Invert seekbar and textviews on right to left reader
- Update dependencies. Update last chapter read in MAL only when the reader is left, instead of on every chapter change. Other minor improvements.
- Changes to viewpager readers
- Catalogue now has a dropdown menu to select or change the source
- Improve MAL support (UI is very simple yet).
- Show version (commit count) and build time in the 'about' section
- Recover manga activity status when the process restarts
- Better alignment for bottom toolbar in chapters fragment
- Recover reader from process restart
- Changes:
- Minor changes
- Improvements for downloads fragment
- Animate recycler view decorations
- Update download progress in chapters fragment
- Another fix for batoto chapter dates
- Improve info fragment. Other minor changes and fixes.
- Avoid filename conflicts (not sure if it will be totally fixed). Check if a chapter is properly downloaded after download finishes.
- Better error handling for downloads
- Minor changes
- Improve the use and caching of the covers' cache. Use restartables in LibraryPresenter
- Use download queue subject for updating chapter status
- Improve the refresh of chapter filters
- Use local filtering. Use long class instead of primitives again for database keys (they can be null)
- Minor changes
- Rename variable to a more suitable one (keeping column name for backwards compatibility)
- Minor changes
- Show download status in chapters fragment
- Merge pull request #8 from icanit/master
- Expanding chapter item menu button layout
- Merge remote-tracking branch 'inorichi/master'
- Get rid of getView() calls in Chapters presenter. Minor changes in download manager
- Minor changes
- Merge pull request #7 from icanit/master
- Merge remote-tracking branch 'inorichi/master'
- Merge pull request #6 from icanit/master
- No next chapter toast on play button
- UI improvements 2
- Merge remote-tracking branch 'inorichi/master'
- Simplify chapter's popup logic
- Changes:
- UI improvements
- Merge remote-tracking branch 'inorichi/master'
- Complete Kissmanga
- Make title a bit smaller and remove unneeded padding
- Merge pull request #4 from icanit/master
- Merge remote-tracking branch 'inorichi/master'
- Improve chapter recognition
- Chapter view improvements
- Merge remote-tracking branch 'inorichi/master'
- Merge pull request #3 from icanit/master
- Merge remote-tracking branch 'inorichi/master'
- Don't store sources domain in database
- UI improvements
- Merge remote-tracking branch 'inorichi/master'
- Improve reader gestures. Upgrade gradle and retrolambda.
- Merge remote-tracking branch 'inorichi/master'
- Only preload pages without the image url
- Merge remote-tracking branch 'inorichi/master'
- Merge remote-tracking branch 'inorichi/master'
- Update last chapter read in MAL when reaching the last page
- Create chaptersync table for new databases
- Initial MAL support
- Merge remote-tracking branch 'inorichi/master'
- Rename tables classes
- Minor fixes
- Merge pull request #2 from icanit/master
- UI improvement Phase 1
- Complete Mangafox and other minor changes
- Some reordering and renaming
- Use smaller icons
- Improve reader options menu. Allow to select default viewer per manga. Allow to lock screen rotation. Working on more options.
- Show animations on reader menu. Don't retain fragment instances in ViewPagerReader.
- Destroy fragment's presenter when they aren't needed using FragmentStack class from Nucleus' examples
- Reorganize strings. Close reader activity when page list throws an exception and notify it.
- Minor changes
- Allow manual retries of images (needs improvement)
- Allow to load next and previous chapter for horizontal readers
- Improve sources' paging
- Reorganize data package
- Upgrade dependencies
- Organize ui by feature instead of layer
- New source (unfinished)
- Automatically close dialog when login is successful and notify user by toast
- More improvements to webtoon viewer
- Initial chapter number recognition (needs improvement). Remove an old class.
- Some improvements to viewers
- Don't copy paste without reading it again
- Update number of downloaded images in the queue, and improve the way the view refreshes the data
- Merge database operations in a single class, deleting duplicated methods (as observable or blocking) and let the consumer decide the option
- Hold a wake lock until downloads are finished
- Allow to resume downloads when a connection is again available
- Bugfixes in download manager and other minor changes
- Change the download event. Fix some bugs in download manager. Other minor changes.
- Download queue threads are now updated when the setting change
- Listen for downloaded pages, but it's not updating the UI yet
- Minor changes
- Use flatMap with a limit instead of windows for concurrent downloads
- Initial download queue fragment. Update progress working
- Allow to delete downloaded chapters
- Read downloaded chapters
- Improve download manager. Add an option to select the number of threads for downloads.
- Allow reading downloaded chapters
- Initial download manager
- Allow to remove a favorite manga from info tab
- Refresh button in library is now looking for new chapters in sources and notifying the user
- Show toast when source login is needed
- Minor changes
- Rename pager adapter and horizontal view pager
- Allow fullscreen reading
- Initial support for read chapters
- Recover page position when configuration changes
- Use BehaviorSubject instead of PublishSubject to observe page progress
- Better handling of loading progress and image load.
- Increase cache size
- Show download progress. Caching of images now without glide
- Retry calls
- Better error handling for images
- Library now showing favorite mangas
- Check credentials before saving
- Authentication with batoto done
- Split source class
- Minor changes again
- Minor changes
- Initial support for sources' login. Upgrade support library version.
- Decouple viewer from the reader activity
- Cache chapter images from presenter with glide.
- Disable tiling, for now
- Allow tapping on the edges of the chapter to change pages
- Move dagger classes to injection directory
- Starting preferences
- Copy nucleus activity and fragment to create a base activity and fragment
- Convert catalogue to a fragment
- Show page number, improve the load of the first image of a chapter
- Reader working. Yay!
- Rename viewer to reader
- Almost showing a chapter reader
- Show chapter count
- Minor changes
- Instant search when leaving search mode
- Search survive screen rotation
- Use subscriptions in onCreate method in CataloguePresenter
- Use nucleus restartables in chapters presenter. Fix some database methods. Add swipe refresh to chapters fragment. Use Icepick library.
- Don't restart library subscription
- Don't query db twice
- Use EventBus
- More changes to MangaDetailActivity and its fragments
- Show chapters tab if it's a manga from library
- Use same activity for manga details on catalague and library. Move some methos to view.
- Delete all view interfaces
- Delete old BasePresenter
- All fragments using Nucleus
- All activities using Nucleus
- Imports cleanup
- Use RxPresenter in Library
- Begin switch to Nucleus
- Introducing nucleus
- Create empty MangaCatalogue
- Rename classes
- Show loading progress bar in catalogue
- Use a publisher to get manga details. Refactor CatalogueListPresenter
- Load catalogue with thumbnails
- Rename library holder
- Simplify if/else
- Search mangas from source (unusable yet)
- Get mangas from search first steps
- Optimize imports. Keep tracking of every subscription
- Load more mangas on scroll
- Show mangas from catalogue
- Create presenter and view for CatalogueList
- Create empty CatalogueListActivity.
- Create catalogue fragment
- Use lambdas in CacheManager
- Move generic methods to Source
- Pull manga details from Batoto
- Separate method pullImageUrlsFromNetwork to allow testing
- Insert or remove chapters with one subscriber
- Update insertOrRemoveChapters method
- Use interfaces for database managers, create a source manager
- Merge branch 'master' of github.com:inorichi/mangafeed
- Initial commit
- Insert or remove method (meh)
- Get chapter list
- Download chapter images
- Send crash reports
- Use constraints, delete chapters when deleting a Manga
- Delete mangas
- Item selection
- Use support fragments
- Unsubscribe subscriptions
- Create adapter in presenter
- Create adapter in presenter
- Observing filter changes shouldn't be needed
- Use Observable to filter library
- Search working
- Search for library (not working)
- Download button
- Insert two dummy mangas
- Show chapter list
- Set toolbar in BaseActivity. Show title in MangaDetailActivity
- Use EasyAdapter
- Compile with Java 8 support for using Retrolambda
- Update library when changes to the DB are made and open manga detail activity
- Get data from database
- Display dummy data
- Make entities' fields public
- Delete boilerplate resources
- Initial commit

### Fixed
- Fix theme action mode
- Fix #11
- Fixed again
- Fix crash on launch...
- Fix inconsistent tab layout
- Fix a crash
- Fix a bug when updating categories in library
- Fix crash with gestures
- Fix MAL autoupdate function.
- Fix NPE when the process restarts in the reader for downloaded chapters and save page list before killing the process.
- Fix some crashes
- Fix commit count command
- Fix library update service
- Fix memory leak in reader
- Fix batoto chapter dates. Remove subjects subscribe schedulers
- Fix chapter recognition. Improve initial requests to fetch chapters from source
- Fix order button
- Fix batoto
- Fix an issue where the next chapter was the same as the current. Fix a NPE when page list throws
- Fix an issue where the retry button wasn't doing anything. Preload the first pages of the next chapter (if available). Show a toast if no next/previous chapter is available. Other minor changes.
- Fix chapter recognition tests
- Fix formatting
- Fix autoformat
- Fix a leak when rotating screen while reading
- Fix bug in reader's current position
- Fix batoto parser
- Fix wrong manga received through EventBus
- Fix crash when searching in the library
- Fix incorrect batoto thumbnail url. Create a function to copy the manga from network to local.
- Fix force close when no more mangas found
- Fix license

### Removed
- Remove cache size setting. Add advanced settings section. Other minor changes.
- Remove PageBundle class
- Remove successful downloads from queue
- Remove chapters on a background thread.
- Remove view logic from catalogue presenter and improve catalogue fragment
- Remove unused util classes
- Remove redundant code

[0.20.4]: https://github.com/ddCeka/mihon/compare/v0.20.3...v0.20.4
[0.20.3]: https://github.com/ddCeka/mihon/compare/v0.20.2...v0.20.3
[0.20.2]: https://github.com/ddCeka/mihon/compare/v0.20.1...v0.20.2
[0.20.1]: https://github.com/ddCeka/mihon/compare/v0.20.0...v0.20.1
[0.20.0]: https://github.com/ddCeka/mihon/compare/v0.19.9...v0.20.0
[0.19.9]: https://github.com/ddCeka/mihon/compare/v0.19.8...v0.19.9
[0.19.8]: https://github.com/ddCeka/mihon/compare/v0.19.7...v0.19.8
[0.19.7]: https://github.com/ddCeka/mihon/compare/v0.19.6...v0.19.7
[0.19.6]: https://github.com/ddCeka/mihon/compare/v0.19.5...v0.19.6
[0.19.5]: https://github.com/ddCeka/mihon/compare/v0.19.4...v0.19.5
[0.19.4]: https://github.com/ddCeka/mihon/compare/v0.19.3...v0.19.4
[0.19.3]: https://github.com/ddCeka/mihon/compare/v0.19.2...v0.19.3
[0.19.2]: https://github.com/ddCeka/mihon/compare/v0.19.1...v0.19.2
[0.19.1]: https://github.com/ddCeka/mihon/compare/v0.19.0...v0.19.1
[0.19.0]: https://github.com/ddCeka/mihon/compare/v0.18.0...v0.19.0
[0.18.0]: https://github.com/ddCeka/mihon/compare/v0.17.1...v0.18.0
[0.17.1]: https://github.com/ddCeka/mihon/compare/v0.17.0...v0.17.1
[0.17.0]: https://github.com/ddCeka/mihon/compare/v0.16.5...v0.17.0
[0.16.5]: https://github.com/ddCeka/mihon/compare/v0.16.4...v0.16.5
[0.16.4]: https://github.com/ddCeka/mihon/compare/v0.16.3...v0.16.4
[0.16.3]: https://github.com/ddCeka/mihon/compare/v0.16.2...v0.16.3
[0.16.2]: https://github.com/ddCeka/mihon/compare/v0.16.1...v0.16.2
[0.16.1]: https://github.com/ddCeka/mihon/compare/v0.16.0...v0.16.1
[0.16.0]: https://github.com/ddCeka/mihon/compare/v0.15.3...v0.16.0
[0.15.3]: https://github.com/ddCeka/mihon/compare/v0.15.2...v0.15.3
[0.15.2]: https://github.com/ddCeka/mihon/compare/v0.15.1...v0.15.2
[0.15.1]: https://github.com/ddCeka/mihon/compare/v0.14.7...v0.15.1
[0.14.7]: https://github.com/ddCeka/mihon/compare/v0.14.6...v0.14.7
[0.14.6]: https://github.com/ddCeka/mihon/compare/v0.14.5...v0.14.6
[0.14.5]: https://github.com/ddCeka/mihon/compare/v0.14.4...v0.14.5
[0.14.4]: https://github.com/ddCeka/mihon/compare/v0.14.3...v0.14.4
[0.14.3]: https://github.com/ddCeka/mihon/compare/v0.14.2...v0.14.3
[0.14.2]: https://github.com/ddCeka/mihon/compare/v0.14.1...v0.14.2
[0.14.1]: https://github.com/ddCeka/mihon/compare/v0.14.0...v0.14.1
[0.14.0]: https://github.com/ddCeka/mihon/compare/v0.13.6...v0.14.0
[0.13.6]: https://github.com/ddCeka/mihon/compare/v0.13.5...v0.13.6
[0.13.5]: https://github.com/ddCeka/mihon/compare/v0.13.4...v0.13.5
[0.13.4]: https://github.com/ddCeka/mihon/compare/v0.13.3...v0.13.4
[0.13.3]: https://github.com/ddCeka/mihon/compare/v0.13.2...v0.13.3
[0.13.2]: https://github.com/ddCeka/mihon/compare/v0.13.1...v0.13.2
[0.13.1]: https://github.com/ddCeka/mihon/compare/v0.13.0...v0.13.1
[0.13.0]: https://github.com/ddCeka/mihon/compare/v0.12.3...v0.13.0
[0.12.3]: https://github.com/ddCeka/mihon/compare/v0.12.2...v0.12.3
[0.12.2]: https://github.com/ddCeka/mihon/compare/v0.12.1...v0.12.2
[0.12.1]: https://github.com/ddCeka/mihon/compare/v0.12.0...v0.12.1
[0.12.0]: https://github.com/ddCeka/mihon/compare/v0.11.1...v0.12.0
[0.11.1]: https://github.com/ddCeka/mihon/compare/v0.11.0...v0.11.1
[0.11.0]: https://github.com/ddCeka/mihon/compare/v0.10.12...v0.11.0
[0.10.12]: https://github.com/ddCeka/mihon/compare/v0.10.11...v0.10.12
[0.10.11]: https://github.com/ddCeka/mihon/compare/v0.10.10...v0.10.11
[0.10.10]: https://github.com/ddCeka/mihon/compare/v0.10.9...v0.10.10
[0.10.9]: https://github.com/ddCeka/mihon/compare/v0.10.8...v0.10.9
[0.10.8]: https://github.com/ddCeka/mihon/compare/v0.10.7...v0.10.8
[0.10.7]: https://github.com/ddCeka/mihon/compare/v0.10.6...v0.10.7
[0.10.6]: https://github.com/ddCeka/mihon/compare/v0.10.5...v0.10.6
[0.10.5]: https://github.com/ddCeka/mihon/compare/v0.10.4...v0.10.5
[0.10.4]: https://github.com/ddCeka/mihon/compare/v0.10.3...v0.10.4
[0.10.3]: https://github.com/ddCeka/mihon/compare/v0.10.2...v0.10.3
[0.10.2]: https://github.com/ddCeka/mihon/compare/v0.10.1...v0.10.2
[0.10.1]: https://github.com/ddCeka/mihon/compare/v0.10.0...v0.10.1
[0.10.0]: https://github.com/ddCeka/mihon/compare/v0.9.2...v0.10.0
[0.9.2]: https://github.com/ddCeka/mihon/compare/v0.9.1...v0.9.2
[0.9.1]: https://github.com/ddCeka/mihon/compare/v0.9.0...v0.9.1
[0.9.0]: https://github.com/ddCeka/mihon/compare/v0.8.5...v0.9.0
[0.8.5]: https://github.com/ddCeka/mihon/compare/v0.8.4...v0.8.5
[0.8.4]: https://github.com/ddCeka/mihon/compare/v0.8.3...v0.8.4
[0.8.3]: https://github.com/ddCeka/mihon/compare/v0.8.2...v0.8.3
[0.8.2]: https://github.com/ddCeka/mihon/compare/v0.8.1...v0.8.2
[0.8.1]: https://github.com/ddCeka/mihon/compare/v0.8.0...v0.8.1
[0.8.0]: https://github.com/ddCeka/mihon/compare/v0.7.4...v0.8.0
[0.7.4]: https://github.com/ddCeka/mihon/compare/v0.7.3...v0.7.4
[0.7.3]: https://github.com/ddCeka/mihon/compare/v0.7.2...v0.7.3
[0.7.2]: https://github.com/ddCeka/mihon/compare/v0.7.1...v0.7.2
[0.7.1]: https://github.com/ddCeka/mihon/compare/v0.7.0...v0.7.1
[0.7.0]: https://github.com/ddCeka/mihon/compare/v0.6.8...v0.7.0
[0.6.8]: https://github.com/ddCeka/mihon/compare/v0.6.7...v0.6.8
[0.6.7]: https://github.com/ddCeka/mihon/compare/v0.6.6...v0.6.7
[0.6.6]: https://github.com/ddCeka/mihon/compare/v0.6.5...v0.6.6
[0.6.5]: https://github.com/ddCeka/mihon/compare/v0.6.4...v0.6.5
[0.6.4]: https://github.com/ddCeka/mihon/compare/v0.6.3...v0.6.4
[0.6.3]: https://github.com/ddCeka/mihon/compare/v0.6.2...v0.6.3
[0.6.2]: https://github.com/ddCeka/mihon/compare/v0.6.1...v0.6.2
[0.6.1]: https://github.com/ddCeka/mihon/compare/v0.6.0...v0.6.1
[0.6.0]: https://github.com/ddCeka/mihon/compare/v0.5.2...v0.6.0
[0.5.2]: https://github.com/ddCeka/mihon/compare/v0.5.1...v0.5.2
[0.5.1]: https://github.com/ddCeka/mihon/compare/v0.5.0...v0.5.1
[0.5.0]: https://github.com/ddCeka/mihon/compare/v0.4.2...v0.5.0
[0.4.2]: https://github.com/ddCeka/mihon/compare/v0.4.1...v0.4.2
[0.4.1]: https://github.com/ddCeka/mihon/compare/v0.4.0...v0.4.1
[0.4.0]: https://github.com/ddCeka/mihon/compare/v0.3.2...v0.4.0
[0.3.2]: https://github.com/ddCeka/mihon/compare/v0.3.1...v0.3.2
[0.3.1]: https://github.com/ddCeka/mihon/compare/v0.3.0...v0.3.1
[0.3.0]: https://github.com/ddCeka/mihon/compare/v0.2.3...v0.3.0
[0.2.3]: https://github.com/ddCeka/mihon/compare/v0.2.2...v0.2.3
[0.2.2]: https://github.com/ddCeka/mihon/compare/v0.2.0...v0.2.2
[0.2.0]: https://github.com/ddCeka/mihon/compare/v0.1.4...v0.2.0
[0.1.4]: https://github.com/ddCeka/mihon/compare/v0.1.3...v0.1.4
[0.1.3]: https://github.com/ddCeka/mihon/compare/v0.1.2...v0.1.3
[0.1.2]: https://github.com/ddCeka/mihon/compare/v0.1.1...v0.1.2
[0.1.1]: https://github.com/ddCeka/mihon/compare/v0.1.0...v0.1.1


