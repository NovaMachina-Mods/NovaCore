# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/), and this project adheres to [NeoForged Semantic Versioning](https://docs.neoforged.net/docs/gettingstarted/versioning).

## [2.0.0](https://github.com/NovaMachina-Mods/NovaCore/compare/v1.0.0...v2.0.0) - 2024-03-14

### Added
- BlockState provider
- Recipe provider
- Abstract Recipe and RecipeSerializer

### Changed
- Updated to NeoForge 20.4.167
- Replace all references of Forge with NeoForge
- Replace `ForgeRegistries` with either `BuiltInRegistries` or `NeoForgeRegistries`
- Use Codec encoding for `FluidStack` and `ItemStack`
- Replace `ExistingFileHelper` in `RecipeProvider` with `CompletableFuture<HolderLookup.Provider>`
- `Consumer<FinishedRecipe>` -> `RecipeOutput`
- `AbstractLangGenerator` is now abstract
- Falling block factory method returns ColoredFallingBlock with color value -8356741

### Removed
- Lombok
- Some `@NonNull` and `@Nullable`
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
