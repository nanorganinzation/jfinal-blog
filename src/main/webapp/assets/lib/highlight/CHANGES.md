## Version 10.2.1

Parser Engine:

-  fix(parser) complete fix for resuming matches from same index (#2678) [Josh Goebel][]

[Josh Goebel]: https://github.com/yyyc514


## Version 10.2.0

Parser Engine:

- (fix) When ignoring a potential match highlighting can terminate early (#2649) [Josh Goebel][]

New themes:

- *Gradient Light* by [Samia Ali]()

Deprecations:

- `fixMarkup` is now deprecated and will be removed in v11.0. (#2534) [Josh Goebel][]

Big picture:

- Add simple Vue plugin for basic use cases (#2544) [Josh Goebel][]

Language Improvements:

- fix(bash) Fewer false positives for keywords in arguments (#2669) [sirosen][]
- fix(js) Prevent long series of /////// from causing freezes (#2656) [Josh Goebel][]
- enh(csharp) Add `init` and `record` keywords for C# 9.0 (#2660) [Youssef Victor][]
- enh(matlab) Add new R2019b `arguments` keyword and fix `enumeration` keyword (#2619) [Andrew Janke][]
- fix(kotlin) Remove very old keywords and update example code (#2623) [kageru][]
- fix(night) Prevent object prototypes method values from being returned in `getLanguage` (#2636) [night][]
- enh(java) Add support for `enum`, which will identify as a `class` now (#2643) [ezksd][]
- enh(nsis) Add support for NSIS 3.06 commands (#2653) [idleberg][]
- enh(php) detect newer more flexible HEREdoc syntax (#2658) [eytienne][]

[Youssef Victor]: https://github.com/Youssef1313
[Josh Goebel]: https://github.com/yyyc514
[Andrew Janke]: https://github.com/apjanke
[Samia Ali]: https://github.com/samiaab1990
[kageru]: https://github.com/kageru
[night]: https://github.com/night
[ezksd]: https://github.com/ezksd
[idleberg]: https://github.com/idleberg
[eytienne]: https://github.com/eytienne
[sirosen]: https://github.com/sirosen


## Version 10.1.1

Fixes:

- Resolve issue on Node 6 due to dangling comma (#2608) [Edwin Hoogerbeets][]
- Resolve `index.d.ts is not a module` error (#2603) [Josh Goebel][]

[Josh Goebel]: https://github.com/yyyc514
[Edwin Hoogerbeets]: https://github.com/ehoogerbeets


## Version 10.1.0

New themes:

- *NNFX* and *NNFX-dark* by [Jim Mason][]
- *lioshi* by [lioshi][]

Parser Engine:

- (parser) Now escapes quotes in text content when escaping HTML (#2564) [Josh Goebel][]
- (parser) Adds `keywords.$pattern` key to grammar definitions (#2519) [Josh Goebel][]
- (parser) Adds SHEBANG utility mode [Josh Goebel][]
- (parser) Adds `registerAliases` method (#2540) [Taufik Nurrohman][]
- (enh) Added `on:begin` callback for modes (#2261) [Josh Goebel][]
- (enh) Added `on:end` callback for modes (#2261) [Josh Goebel][]
- (enh) Added ability to programatically ignore begin and end matches (#2261) [Josh Goebel][]
- (enh) Added `END_SAME_AS_BEGIN` mode to replace `endSameAsBegin` parser attribute (#2261) [Josh Goebel][]
- (fix) `fixMarkup` would rarely destroy markup when `useBR` was enabled (#2532) [Josh Goebel][]

Deprecations:

- `htmlbars` grammar is now deprecated. Use `handlebars` instead. (#2344) [Nils Knappmeier][]
- when using `highlightBlock` `result.re` deprecated. Use `result.relevance` instead. (#2552) [Josh Goebel][]
- ditto for `result.second_best.re` => `result.second_best.relevance` (#2552)
- `lexemes` is now deprecated in favor of `keywords.$pattern` key (#2519) [Josh Goebel][]
- `endSameAsBegin` is now deprecated. (#2261) [Josh Goebel][]

Language Improvements:

- fix(groovy) strings are not allowed inside ternary clauses (#2217) [Josh Goebel][]
- fix(typescript) add `readonly` keyword (#2562) [Martin (Lhoerion)][]
- fix(javascript) fix regex inside parens after a non-regex (#2530) [Josh Goebel][]
- enh(typescript) use identifier to match potential keywords, preventing false positivites (#2519) [Josh Goebel][]
- enh(javascript) use identifier to match potential keywords, preventing false positivites (#2519) [Josh Goebel][]
- [enh] Add `OPTIMIZE:` and `HACK:` to the labels highlighted inside comments [Josh Goebel][]
- enh(typescript/javascript/coffeescript/livescript) derive ECMAscript keywords from a common foudation (#2518) [Josh Goebel][]
- enh(typescript) add setInterval, setTimeout, clearInterval, clearTimeout (#2514) [Josh Goebel][]
- enh(javascript) add setInterval, setTimeout, clearInterval, clearTimeout (#2514) [Vania Kucher][]
- enh(cpp) add `pair`, `make_pair`, `priority_queue` as built-ins (#2538) [Hankun Lin][]
- enh(cpp) recognize `priority_queue` `pair` as cpp containers (#2541) [Hankun Lin][]
- fix(javascript) prevent `set` keyword conflicting with setTimeout, etc. (#2514) [Vania Kucher][]
- fix(cpp) Fix highlighting of unterminated raw strings (#2261) [David Benjamin][]
- fix(javascript) `=>` function with nested `()` in params now works (#2502) [Josh Goebel][]
- fix(typescript) `=>` function with nested `()` in params now works (#2502) [Josh Goebel][]
- fix(yaml) Fix tags to include non-word characters (#2486) [Peter Plantinga][]
- fix(swift) `@objcMembers` was being partially highlighted (#2543) [Nick Randall][]
- enh(dart) Add `late` and `required` keywords, the `Never` built-in type, and nullable built-in types (#2550) [Sam Rawlins][]
- enh(erlang) Add underscore separators to numeric literals (#2554) [Sergey Prokhorov][]
- enh(handlebars) Support for sub-expressions, path-expressions, hashes, block-parameters and literals (#2344) [Nils Knappmeier][]
- enh(protobuf) Support multiline comments (#2597) [Pavel Evstigneev][]
- fix(toml) Improve key parsing (#2595) [Antoine du Hamel][]

[Josh Goebel]: https://github.com/yyyc514
[Peter Plantinga]: https://github.com/pplantinga
[David Benjamin]: https://github.com/davidben
[Vania Kucher]: https://github.com/qWici
[Hankun Lin]: https://github.com/Linhk1606
[Nick Randall]: https://github.com/nicked
[Sam Rawlins]: https://github.com/srawlins
[Sergey Prokhorov]: https://github.com/seriyps
[Nils Knappmeier]: https://github.com/nknapp
[Martin (Lhoerion)]: https://github.com/Lhoerion
[Jim Mason]: https://github.com/RocketMan
[lioshi]: https://github.com/lioshi
[Pavel Evstigneev]: https://github.com/Paxa
[Antoine du Hamel]: https://github.com/aduh95


## Version 10.0.2

Brower build:

- [Issue](https://github.com/highlightjs/highlight.js/issues/2505) (bug) Fix: Version 10 fails to load as CommonJS module. (#2511) [Josh Goebel][]
- [Issue](https://github.com/highlightjs/highlight.js/issues/2505) (removal) AMD module loading support has been removed. (#2511) [Josh Goebel][]

Parser Engine Changes:

- [Issue](https://github.com/highlightjs/highlight.js/issues/2522) fix(parser) Fix freez issue with illegal 0 width matches (#2524) [Josh Goebel][]


[Josh Goebel]: https://github.com/yyyc514


## Version 10.0.1

Parser Engine Changes:

- (bug) Fix sublanguage with no relevance score (#2506) [Josh Goebel][]

[Josh Goebel]: https://github.com/yyyc514


## Version 10.0.0

New languages:

- add(php-template) Explicit language to detect PHP templates (vs xml) [Josh Goebel][]
- enh(python) Added `python-repl` for Python REPL sessions
- add(never) Added 3rd party Never language support

New themes:

- *Srcery* by [Chen Bin][]

Parser Engine Changes:

- (bug) Fix `beginKeywords` to ignore . matches (#2434) [Josh Goebel][]
- (enh) add `before:highlight` plugin API callback (#2395) [Josh Goebel][]
- (enh) add `after:highlight` plugin API callback (#2395) [Josh Goebel][]
- (enh) split out parse tree generation and HTML rendering concerns (#2404) [Josh Goebel][]
- (enh) every language can have a `name` attribute now (#2400) [Josh Goebel][]
- (enh) improve regular expression detect (less false-positives) (#2380) [Josh Goebel][]
- (enh) make `noHighlightRe` and `languagePrefixRe` configurable (#2374) [Josh Goebel][]

Language Improvements:

- enh(python) Exclude parens from functions params (#2490) [Álvaro Mondéjar][]
- enh(swift) Add `compactMap` to keywords as built_in (#2478) [Omid Golparvar][]
- enh(nim) adds `func` keyword (#2468) [Adnan Yaqoob][]
- enh(xml) deprecate ActionScript inside script tags (#2444) [Josh Goebel][]
- fix(javascript) prevent get/set variables conflicting with keywords (#2440) [Josh Goebel][]
- bug(clojure) Now highlights `defn-` properly (#2438) [Josh Goebel][]
- enh(bash) default value is another variable (#2439) [Josh Goebel][]
- enh(bash) string nested within string (#2439) [Josh Goebel][]
- enh(bash) Add arithmetic expression support (#2439) [Josh Goebel][]
- enh(clojure) Add support for global definitions name (#2347) [Alexandre Grison][]
- enh(fortran) Support Fortran 77 style comments (#2416) [Josh Goebel][]
- (csharp) add support for `@identifier` style identifiers (#2414) [Josh Goebel][]
- fix(elixir) Support function names with a slash (#2406) [Josh Goebel][]
- fix(javascript) comma is allowed in a "value container" (#2403) [Josh Goebel][]
- enh(apache) add `deny` and `allow` keywords [Josh Goebel][]
- enh(apache) highlight numeric attributes values [Josh Goebel][]
- enh(apache) highlight IP addresses, ports, and strings in sections [Josh Goebel][]
- enh(php) added more keywords and include `<?=` syntax to meta [Taufik Nurrohman][]
- fix(protobuf) Fix `rpc` when followed by a block (#) [Josh Goebel][]
- enh(zephir) almost complete rework of the zephir grammar (#2387) [Josh Goebel][]
- (markdown) much improved code block support (#2382) [Josh Goebel][]
- (markdown) improve bold/italic nesting (#2382) [Josh Goebel][]
- enh(csharp) Support `where` keyword as class constraint (#2378) [Josh Goebel][]
- enh(csharp) Allow reference path in class inheritance lists (#2378) [Josh Goebel][]
- enh(csharp) Add generic modifiers (in, out) (#2378) [Josh Goebel][]
- (fortran) enh(fortran) support intrinsic data types (#2379) [Josh Goebel][]
- enh(java) annotations can include numbers (#2377) [Josh Goebel][]
- enh(java) annotations can take params (#2377) [Josh Goebel][]
- enh(java) allow annotations inside function call params (#2377) [Josh Goebel][]
- enh(parser) pre/post-highlightBlock callbacks via plugin (#2285) [Josh Goebel][]
- (fortran) Add Fortran 2018 keywords and coarray intrinsics (#2361) [Sam Miller][]
- (delphi) highlight hexadecimal, octal, and binary numbers (#2370) [Robert Riebisch]()
- enh(plaintext) added `text` and `txt` as alias (#2360) [Taufik Nurrohman][]
- enh(powershell) added PowerShell v5.1/v7 default aliases as "built_in"s (#2423) [Sean Williams][]
- enh(yaml) added support for timestamps (#2475) [Peter Plantinga][]

Developer Tools:

- added Dockerfile for optionally developing with a container

[Omid Golparvar]: https://github.com/omidgolparvar
[Alexandre Grison]: https://github.com/agrison
[Josh Goebel]: https://github.com/yyyc514
[Chen Bin]: https://github.com/redguardtoo
[Sam Miller]: https://github.com/smillerc
[Robert Riebisch]: https://github.com/bttrx
[Taufik Nurrohman]: https://github.com/taufik-nurrohman
[Josh Goebel]: https://github.com/yyyc514
[Sean Williams]: https://github.com/hmmwhatsthisdo
[Adnan Yaqoob]: https://github.com/adnanyaqoobvirk
[Álvaro Mondéjar]: https://github.com/mondeja


## Version 9.18.1

Grammar Improvements:

- bug(coffeescript) fix freezing bug due to badly behaved regex (#2376) [Josh Goebel][]

[Josh Goebel]: https://github.com/yyyc514


## Version 9.18.0

New languages:

- none.

New themes:

- none.

Core Changes:

- none.

Language Improvements:

- (javascript) fix JSX self-closing tag issues (#2322) [Josh Goebel][]
- (fortran) added `block` and `endblock` keywords (#2343) [Philipp Engel][]
- (javascript) support jsx fragments (#2333) [Josh Goebel][]
- (ini) support TOML arrays, clean up grammar (#2335) [Josh Goebel][]
- (vbnet) add nameof operator to the keywords (#2329) [Youssef Victor][]
- (stan) updated with improved coverage of language keywords and patterns. (#1829) [Jeffrey Arnold][]
- enh(cpp) Detect namespaced function types (`A::typeName func(...)`) (#2332) [Josh Goebel][]
- enh(cpp) Detect namespaced functions also (`A::functionName`) (#2332) [Josh Goebel][]
- enh(cpp) Properly detect decltype(auto) (#2332) [Josh Goebel][]
- enh(cpp) recognize primitive types (`int8_t`, etc.) as function types (#2332) [Josh Goebel][]

Developer Tools:

- feat(developer): add button to show parsed structure (#2345) [Nils Knappmeier][]

[Jeffrey Arnold]: https://github.com/jrnold
[Josh Goebel]: https://github.com/yyyc514
[Philipp Engel]: https://github.com/interkosmos
[Youssef Victor]: https://github.com/Youssef1313
[Nils Knappmeier]: https://github.com/nknapp


## Version 9.17.1

Fixes:

- fix(parser): resolve IE 11 issue with Object.freeze() (#2319) [Josh Goebel][]

[Josh Goebel]: https://github.com/yyyc514


## Version 9.17.0

New languages:

- none.

New themes:

- *Gradient Dark* by [Samia Ali][]

Core Improvements:

- chore(parser): switch from `createElementNS` to `createElement` (#2314) [Josh Goebel][]
- enh(parser): add better error when a language requirement is missing (#2311) [Josh Goebel][]
- fix(parser/docs): disallow `self` mode at the top-level of a language (#2294) [Josh Goebel][]
- enh(parser) add safe & debug modes.  Better error handling for crash conditions. (#2286) [Josh Goebel][]
- fix(parser): Fix merger HTML attribute quoting (#2235) [Josh Goebel][]
- fix(parser): Look-ahead regex now work for end matches also (#2237) [Josh Goebel][]
- fix(parser): Better errors when a language is missing (#2236) [Josh Goebel][]
- fix(parser): freeze built-in modes to prevent grammars altering them (#2271) [Josh Goebel][]
- fix(themes): fix inconsistencies between some themes padding/spacing (#2300) [Josh Goebel][]
- ehh(build) Add CI check for building a "use strict" safe rollup package from NPM builds (#2247) [Josh Goebel][]
- fix(pkg): Prefix global addEventListener with window to be able to minify with closure compiler (#2305) [Kirill Saksin]()

Language Improvements:

- fix(sql): backslash is not used to escape in strings in standard SQL (#1748) [Mike Schall][]
- enh(ebnf) add backticks as additional string variant (#2290) [Chris Marchesi][]
- chore(javascript): add esm related extensions to aliases (#2298) [Rongjian Zhang][]
- fix(kotlin): fix termination of """ string literals (#2295) [Josh Goebel][]
- fix(mercury): don't change global STRING modes (#2271) [Josh Goebel][]
- enh(xml) expand and improve document type highlighting (#2287) [w3suli][]
- enh(ebnf) add underscore as allowed meta identifier character, and dot as terminator (#2281) [Chris Marchesi][]
- fix(makefile) fix double relevance for assigns, improves auto-detection (#2278) [Josh Goebel][]
- enh(xml) support for highlighting entities (#2260) [w3suli][]
- enh(gml) fix naming of keyword class (consistency fix) (#2254) [Liam Nobel][]
- enh(javascript): Add support for jsdoc comments (#2245) [Milutin Kristofic][]
- fix(python) fix `if` getting confused as an f-string (#2200) [Josh Goebel][] and [Carl Baxter][]
- enh(powershell) major overhaul, huge improvements (#2224)
- enh(css) Improve @rule highlighting, including properties (#2241) [Josh Goebel][]
- enh(css) Improve highlighting of numbers inside expr/func `calc(2px+3px)` (#2241)
- enh(scss) Pull some of the CSS improvements back into SCSS (#2241)
- fix(go): Fix escaped character literals (#2266) [David Benjamin][]
- fix(objectivec): Fix various preprocessor highlighting issues (#2265) [David Benjamin][]
- fix(objectivec): Handle multibyte character literals (#2268) [David Benjamin][]
- enh(cpp): Add additional keywords (#2289) [Adrian Ostrowski][]

[Josh Goebel]: https://github.com/yyyc514
[Liam Nobel]: https://github.com/liamnobel
[Carl Baxter]: https://github.com/cdbax
[Milutin Kristofic]: https://github.com/milutin
[w3suli]: https://github.com/w3suli
[David Benjamin]: https://github.com/davidben
[Chris Marchesi]: https://github.com/vancluever
[Adrian Ostrowski]: https://github.com/aostrowski
[Rongjian Zhang]: https://github.com/pd4d10
[Mike Schall]: https://github.com/schallm
[Kirill Saksin]: https://github.com/saksmt
[Samia Ali]:https://github.com/samiaab1990


## Version 9.16.2

New languages:
  none.

New styles:
  none.

Improvements:
- fix(arduino) Resolves issue with arduino.js not being "use strict" safe (#2247)


## Version 9.16.1

New languages:
  none.

New styles:
- *Night Owl* by [Carl Baxter][]

Improvements:
- Add CLI tool to quickly check for relevance conflicts [Mark Ellis][] (#1554)
- enhance(twig) update list of filter and tags (#2090)
- fix(crystal): correctly highlight `!~` method definition (#2222)
- fix dropping characters if we choke up on a 0-width match (#2219)
- (accesslog) improve accesslog relevancy scoring (#2172)
- fix(shell): fix parsing of prompts with forward slash (#2218)
- improve parser to properly support look-ahead regex in begin matchers (#2135)
- blacklist super-common keywords from having relevance (#2179)
- fix(swift): support for `@dynamicMemberLookup` and `@propertyWrapper` (#2202)
- fix: `endWithParent` inside `starts` now always works (#2201)
- fix(typescript): constructor in declaration doesn't break highlighting
- fix(typescript): only match function keyword as a separate identifier (#2191)
- feature(arduino) make arduino a super-set of cpp grammar
- fix(javascript): fix object attributes immediately following line comments
- fix(xml): remove `vbscript` as potential script tag subLanguage
- fix(Elixir): improve regex for numbers
- fix(YAML): improve matching for keys, blocks and numbers
- fix(Pony): improve regex for numbers
- fix(handlebars): add support for raw-blocks, and triple-mustaches(#2175)
- fix(handlebars): fix parsing of block-comments containing closing mustaches (#2175)
- fix(handlebars): add support for segment-literal notation, and escaped mustaches (#2184)
- JSON: support for comments in JSON (#2016)
- fix(cpp): improve string literal matching
- fix(highlight.js): omit empty span-tags in the output (#2182)
- fix(Go): improve function declaration matching
- fix(python): added support for f-string literal curly braces (#2195)
- fix(cpp): add `future` built-in (#1610)
- fix(python): support comments within function parameters (#2214)

[Carl Baxter]: https://github.com/cdbax
[Mark Ellis]: https://github.com/ellismarkf

## Version 9.15.10
New languages:
  none.
New styles:
  none.
Improvements:
  - support for ruby's squiggly heredoc (#2049)
  - support css custom properties (#2082)
  - fix(PureBASIC): update to 5.60 (#1508)
  - fix(Kotlin): parenthesized types in function declaration (#2107)
  - fix(Kotlin): nested comment (#2104)
  - fix(isbl): contains key typo (#2103)
  - fix(github-gist.css): match Github styles (#2100)
  - fix(elm): update to latest elm syntax (#2088)
  - fix: Support highlighting inline HTML and CSS tagged template strings in JS and TS (#2105)
  - feat(YAML): add YAML to common languages (#1952)
  - feat(xml): Add support for Windows Script File (.wsf), inline VBScript in XML `script` tags (#1690)

## Version 9.15.9

Improvements:
 - fix(AutoHotkey): order and extended highlighting (#1579)
 - fix(Go): correctly highlight hex numbers, rather than stopping at last 'd' or 'f'. (#2060)
 - fix(Mathematica): Improvements to language (#2065)
 - fix(Node): Adds SCSS build (#2079)
 - fix(Rust): update keywords (#2052)
 - fix(Stata): Added keywords for the meta-analysis suite introduced in Stata 16 (#2081)
 - fix(Bash): escape double quotes (#2048)

## Version 9.15.8

New languages:
  none.
New styles:
  none.
Improvements:
  - fix(bash): revert escaped double quotes - broke Firefox/Safari.

## Version 9.15.7
New languages:
  none.
New styles:
  none.
Improvements:
 - fix(powershell): Add cmdlets (#2022)
 - fix(Bash): escaped double quotes (#2041)
 - fix(c++): add aliases 'hh', 'hxx', 'cxx' (#2017)
 - fix(ini/toml): Support comments on the same line. (#2039)
 - fix(JSX): not rendering well in a function without parentheses. (#2024)
 - fix(LiveCode): language definition update (#2021)
 - fix(markdown): indented lists (#2004)
 - fix(styles/school-book): don't style all the pre, use .hljs instead (#2034)
 - fix(JSX): Modify JSX tag detection to use XML language regex in place of simplistic \w+

## Version 9.15.6
New languages:
    none.
New styles:
    none.
Improvements:
 - Move dependencies to be devDependencies.
 - Fixed security issues in dev dependencies.

## Version 9.15.5
New languages:
    none.
New styles:
    none.
Improvements:
  🔥 Hot fix: updated build tool.

## Version 9.15.4
New languages:
    none.
New styles:
    none.
Improvements:
  🔥 Hot fix: reverted hljs cli build tool, as it was causing issues with install.

## Version 9.15.3
New languages:
    none.
New styles:
    none.
Improvements:
  🔥 Hot fix: reverted hljs cli build tool, as it was causing issues with install.

## Version 9.15.2
New languages:
    none.
New styles:
    none.
Improvements:
  🔥 Hot fix that was preventing highlight.js from installing.

## Version 9.15.1

New languages:
    none.

New styles:
    none.

Improvements:

- Pony: Fixed keywords without spaces at line ends, highlighting of `iso` in class definitions, and function heads without bodies in traits and interfaces. Removed FUNCTION and CLASS modes until they are found to be needed and to provide some of the fixes.
 - Support external language files in minified version of highlight.js (#1888)

## Version 9.15

New languages:
    none.

New styles:
    none.

Improvements:
 - new cli tool `hljs` - allows easier [building from command line](docs/building-testing.rst#building-a-bundle-from-the-command-line).
 - cpp: Fully support C++11 raw strings. (#1897)
 - Python: Treat False None and True as literals (#1920)

## Version 9.14.2

New languages:
  none.
New styles:
  none.
Improvements:
- *Gauss* fixed to stop global namespace pollution [Scott Hyndman][].
- fix(Tcl): removed apostrophe string delimiters (don't exist)

[Scott Hyndman]: https://github.com/shyndman

## Version 9.14.1

New languages:
    none.
New styles:
    none.
Improvements:
- Pony: language improvements (#1958)

## Version 9.14.0

New languages:
    none.
New styles:
    none.
Improvements:
- Pony: add missing "object" highlighting (#1932)
- Added *XQuery* built-in functions, prolog declarations, as well as parsing of function bodies, computed and direct constructors, by [Duncan Paterson][]
- fix(dart): Corrects highlighting with string interpolation. (#1946)
- fix(swift): be eager on optional-using types (!/?) (#1919)
- fix(tex): Changed cyrillic to unicode (IE11 throw SCRIPT5021) (#1601)
- fix(JavaScript): Recognize get/set accessor keywords (#1940)
- Fixed Dockerfile definition when using highlight continuation parameter, by [Laurent Voullemier][]
- Added tests & new `annotation` and `verbatim` keywords to *Crystal*, by [Benoit de Chezelles][]
- Added missing dockerfile markup tests, by [Laurent Voullemier][]
  Allow empty prompt text in clojure-repl, by [Egor Rogov][]
- Fixed several issues with *Crystal* language definition, by [Johannes Müller][]
- Added `C#` as an alias for *CSharp* language, by [Ahmed Atito][]
- Added generic user-defined proc support, new compiler define, refactor to re-use rules, and add tests to *GAUSS*, by [Matthew Evans][]
- Improve *Crystal* language to highlight regexes after some keywords, by [Tsuyusato Kitsune][]
- Fix filterByQualifiers: fileInfo can be null
- Fixed String interpolation in Dart, by [Scott Hyndman][].

[Laurent Voullemier]: https://github.com/l-vo
[Benoit de Chezelles]: https://github.com/bew
[Johannes Müller]: https://github.com/straight-shoota
[Ahmed Atito]: https://github.com/atitoa93
[Matthew Evans]: https://github.com/matthewevans
[Tsuyusato Kitsune]: https://github.com/MakeNowJust
[Scott Hyndman]: https://github.com/shyndman
[Duncan Paterson]: https://github.com/duncdrum

## Version 9.13.1

Improvements:

- *C#* function declarations no longer include trailing whitespace, by [JeremyTCD][]
- Added new and missing keywords to *AngelScript*, by [Melissa Geels][]
- *TypeScript* decorator factories highlighting fix, by [Antoine Boisier-Michaud][]
- Added support for multiline strings to *Swift*, by [Alejandro Isaza][]
- Fixed issue that was causing some minifiers to fail.
- Fixed `autoDetection` to accept language aliases.

[JeremyTCD]: https://github.com/JeremyTCD
[Melissa Geels]: https://github.com/codecat
[Antoine Boisier-Michaud]: https://github.com/Aboisier
[Alejandro Isaza]: https://github.com/alejandro-isaza

## Version 9.13.0

New languages:

- *ArcGIS Arcade* by [John Foster][]
- *AngelScript* by [Melissa Geels][]
- *GML* by [meseta][]
- *isbl* built-in language DIRECTUM and Conterra by [Dmitriy Tarasov][].
- *PostgreSQL* SQL dialect and PL/pgSQL language by [Egor Rogov][].
- *ReasonML* by [Gidi Meir Morris][]
- *SAS* by [Mauricio Caceres Bravo][]
- *Plaintext* by [Egor Rogov][]
- *.properties* by [bostko][] and [Egor Rogov][]

New styles:

- *a11y-dark theme* by [Eric Bailey][]
- *a11y-light theme* by [Eric Bailey][]
- *An Old Hope* by [Gustavo Costa][]
- *Atom One Dark Reasonable* by [Gidi Meir Morris][]
- *isbl editor dark* by [Dmitriy Tarasov][]
- *isbl editor light* by [Dmitriy Tarasov][]
- *Lightfair* by [Tristian Kelly][]
- [*Nord*][nord-highlightjs] by [Arctic Ice Studio][]
- *[🦄 Shades of Purple](https://github.com/ahmadawais/Shades-of-Purple-HighlightJS)* by [Ahmad Awais][]

Improvements:

- New attribute `endSameAsBegin` for nested constructs with variable names
  by [Egor Rogov][].
- *Python* highlighting of escaped quotes fixed by [Harmon][]
- *PHP*: Added alias for php7, by [Vijaya Chandran Mani][]
- *C++* string handling, by [David Benjamin][]
- *Swift* Add `@objcMembers` to `@attributes`, by [Berk Çebi][]
- Infrastructural changes by [Marcos Cáceres][]
- Fixed metachars highighting for *NSIS* by [Jan T. Sott][]
- *Yaml* highlight local tags as types by [Léo Lam][]
- Improved highlighting for *Elixir* by [Piotr Kaminski][]
- New attribute `disableAutodetect` for preventing autodetection by [Egor Rogov][]
- *Matlab*: transpose operators and double quote strings, by [JohnC32][] and [Egor Rogov][]
- Various documentation typos and improvemets by [Jimmy Wärting][], [Lutz Büch][], [bcleland][]
- *Cmake* updated with new keywords and commands by [Deniz Bahadir][]

[Ahmad Awais]: https://github.com/ahmadawais
[Arctic Ice Studio]: https://github.com/arcticicestudio
[Dmitriy Tarasov]: https://github.com/MedvedTMN
[Egor Rogov]: https://github.com/egor-rogov
[Eric Bailey]: https://github.com/ericwbailey
[Gidi Meir Morris]: https://github.com/gmmorris
[Gustavo Costa]: https://github.com/gusbemacbe
[Harmon]: https://github.com/Harmon758
[Melissa Geels]: https://github.com/codecat
[meseta]: https://github.com/meseta
[nord-highlightjs]: https://github.com/arcticicestudio/nord-highlightjs
[Tristian Kelly]: https://github.com/TristianK3604
[Vijaya Chandran Mani]: https://github.com/vijaycs85
[John Foster]: https://github.com/jf990
[David Benjamin]: https://github.com/davidben
[Berk Çebi]: https://github.com/berkcebi
[Mauricio Caceres Bravo]: https://github.com/mcaceresb
[bostko]: https://github.com/bostko
[Deniz Bahadir]: https://github.com/Bagira80
[bcleland]: https://github.com/bcleland
[JohnC32]: https://github.com/JohnC32
[Lutz Büch]: https://github.com/lutz-100worte
[Piotr Kaminski]: https://github.com/pkaminski
[Léo Lam]: https://github.com/leoetlino
[Jan T. Sott]: https://github.com/idleberg
[Jimmy Wärting]: https://github.com/jimmywarting
[Marcos Cáceres]: https://github.com/marcoscaceres

## Version 9.12.0

New language:

- *MikroTik* RouterOS Scripting language by [Ivan Dementev][].

New style:

- *VisualStudio 2015 Dark* by [Nicolas LLOBERA][]

Improvements:
- *Crystal* updated with new keywords and syntaxes by [Tsuyusato Kitsune][].
- *Julia* updated to the modern definitions by [Alex Arslan][].
- *julia-repl* added by [Morten Piibeleht][].
- [Stanislav Belov][] wrote a new definition for *1C*, replacing the one that
  has not been updated for more than 8 years. The new version supports syntax
  for versions 7.7 and 8.
- [Nicolas LLOBERA][] improved C# definition fixing edge cases with function
  titles detection and added highlighting of `[Attributes]`.
- [nnnik][] provided a few correctness fixes for *Autohotkey*.
- [Martin Clausen][] made annotation collections in *Clojure* to look
  consistently with other kinds.
- [Alejandro Alonso][] updated *Swift* keywords.

[Tsuyusato Kitsune]: https://github.com/MakeNowJust
[Alex Arslan]: https://github.com/ararslan
[Morten Piibeleht]: https://github.com/mortenpi
[Stanislav Belov]: https://github.com/4ppl
[Ivan Dementev]: https://github.com/DiVAN1x
[Nicolas LLOBERA]: https://github.com/Nicolas01
[nnnik]: https://github.com/nnnik
[Martin Clausen]: https://github.com/maacl
[Alejandro Alonso]: https://github.com/Azoy

## Version 9.11.0

New languages:

- *Shell* by [Tsuyusato Kitsune][]
- *jboss-cli* by [Raphaël Parrëe][]

Improvements:

- [Joël Porquet] has [greatly improved the definition of *makefile*][5b3e0e6].
- *C++* class titles are now highlighted as in other languages with classes.
- [Jordi Petit][] added rarely used `or`, `and` and `not` keywords to *C++*.
- [Pieter Vantorre][] fixed highlighting of negative floating point values.


[Tsuyusato Kitsune]: https://github.com/MakeNowJust
[Jordi Petit]: https://github.com/jordi-petit
[Raphaël Parrëe]: https://github.com/rparree
[Pieter Vantorre]: https://github.com/NuclearCookie
[5b3e0e6]: https://github.com/isagalaev/highlight.js/commit/5b3e0e68bfaae282faff6697d6a490567fa9d44b


## Version 9.10.0

Apologies for missing the previous release cycle. Some thing just can't be
automated… Anyway, we're back!

New languages:

- *Hy* by [Sergey Sobko][]
- *Leaf* by [Hale Chan][]
- *N1QL* by [Andres Täht][] and [Rene Saarsoo][]

Improvements:

- *Rust* got updated with new keywords by [Kasper Andersen][] and then
  significantly modernized even more by [Eduard-Mihai Burtescu][] (yes, @eddyb,
  Rust core team member!)
- *Python* updated with f-literals by [Philipp A][].
- *YAML* updated with unquoted strings support.
- *Gauss* updated with new keywords by [Matt Evans][].
- *Lua* updated with new keywords by [Joe Blow][].
- *Kotlin* updated with new keywords by [Philipp Hauer][].
