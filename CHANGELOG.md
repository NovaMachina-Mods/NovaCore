# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/), and this project adheres to [NeoForged Semantic Versioning](https://docs.neoforged.net/docs/gettingstarted/versioning).

## [1.1.0](https://github.com/NovaMachina-Mods/NovaCore/compare/v1.0.0...v1.1.0) - 2024-01-01

### Added

### Changed

- Replace all references of Forge with NeoForge
- Replace `ForgeRegistries` with either `BuiltInRegistries` or `NeoForgeRegistries`
- Use Codec encoding for `FluidStack` and `ItemStack`
- Replace `Consumer<FinishedRecipe>` with `RecipeOutput`
- Replace `ExistingFileHelper` in `RecipeProvider` with `CompletableFuture<HolderLookup.Provider>`

### Removed

- Removed `id` parameter from `Recipe` as it is no longer used by Vanilla

## [1.0.0](https://github.com/NovaMachina-Mods/NovaCore/compare/v1.0.0) - 2023-10-24

### Added

- Requires NeoForge 47.1.55+
- Bootstrap classes for Neoforge registries
- Common Block Entity renderer
- Mostly framework agnostic definitions for:
  - Blocks
  - Block Entities
  - Creative Tabs
  - Fluids
  - Items
  - Loot Modifiers
  - Recipe Serializers
- Framework agnostic registries for:
  - Block Entity Types
  - Block
  - Creative Tabs
  - Fluids
  - Items
  - Loot Modifiers
  - Recipe Serializers
  - Recipe Types
  - Sound Events
- Data Generation classes for:
  - Recipes
  - Loot Tables
  - Tags
  - Language
- Common utility classes
