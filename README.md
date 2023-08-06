# Android Arch Sample

A sample app demonstrating how I've been writing Android apps in 2023.

This is entirely based on Android's
excellent [Guide to Architecture](https://developer.android.com/topic/architecture).

## This demonstrates:

- Kotlin with coroutines and Flow.
- Hilt for dependency injection.
- Single activity app with fragments.
- [Navigation Component](https://developer.android.com/guide/navigation/get-started) to move between
  fragments.
- UI that fetches info solely from its `ViewModel`s in the form of `UiState`.
- [`Room`](https://developer.android.com/training/data-storage/room)
  and [`Datastore`](https://developer.android.com/topic/libraries/architecture/datastore) for
  persistence.
- An initial view of using `Repo`s for separating persistence APIs from business APIs.

## Future me might (probably not, but maaaybe) add:

- Combining `network` and `persistence` in the `Repo` classes to show how they're truly useful when
  combining multiple sources of data.
- Show how `Activity`, `Fragment` and `ViewModel` should be used to request permissions.

## What the app looks like

(I'm adding this section just because I like it when I open a repo and see screenshots and videos.)

