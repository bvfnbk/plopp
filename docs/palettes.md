# Palettes

This document collects some color palettes which may be used in CSS themes. It uses the SASS dialect because using this
it is possible to define an array of colors and append CSS colors to it and _IntelliJ_ will render the color in the
gutter.

```sass
$theme-colors: []
// background
@debug append($theme-colors, rgb(23, 23, 23))
@debug append($theme-colors, rgb(43, 43, 43))
@debug append($theme-colors, rgb(64, 64, 64))
@debug append($theme-colors, rgb(84, 84, 84))
@debug append($theme-colors, rgb(105, 105, 105))
@debug append($theme-colors, rgb(125, 125, 125))
@debug append($theme-colors, rgb(145, 145, 145))
@debug append($theme-colors, rgb(166, 166, 166))
@debug append($theme-colors, rgb(186, 186, 186))
@debug append($theme-colors, rgb(207, 207, 207))
@debug append($theme-colors, rgb(227, 227, 227))
@debug append($theme-colors, rgb(247, 247, 247))

@debug append($theme-colors, hsl(240, 100%, 5%))
@debug append($theme-colors, hsl(240, 100%, 15%))
@debug append($theme-colors, hsl(240, 100%, 25%))
@debug append($theme-colors, hsl(240, 100%, 35%))
@debug append($theme-colors, hsl(240, 100%, 45%))
@debug append($theme-colors, hsl(240, 100%, 55%))
@debug append($theme-colors, hsl(240, 100%, 65%))
@debug append($theme-colors, hsl(240, 100%, 75%))
@debug append($theme-colors, hsl(240, 100%, 85%))
@debug append($theme-colors, hsl(240, 100%, 95%))
@debug append($theme-colors, hsl(240, 100%, 100%))

@debug append($theme-colors, hsl(40, 57%, 3%))
@debug append($theme-colors, hsl(40, 57%, 11%))
@debug append($theme-colors, hsl(40, 57%, 19%))
@debug append($theme-colors, hsl(40, 57%, 27%))
@debug append($theme-colors, hsl(40, 57%, 35%))
@debug append($theme-colors, hsl(40, 57%, 43%))
@debug append($theme-colors, hsl(40, 57%, 51%))
@debug append($theme-colors, hsl(40, 57%, 59%))
@debug append($theme-colors, hsl(40, 57%, 67%))
@debug append($theme-colors, hsl(40, 57%, 75%))
@debug append($theme-colors, hsl(40, 57%, 83%))
@debug append($theme-colors, hsl(40, 57%, 91%))
@debug append($theme-colors, hsl(40, 57%, 99%))

@debug append($theme-colors, hsl(154, 33%, 6%))
@debug append($theme-colors, hsl(154, 33%, 14%))
@debug append($theme-colors, hsl(154, 33%, 22%))
@debug append($theme-colors, hsl(154, 33%, 30%))
@debug append($theme-colors, hsl(154, 33%, 38%))
@debug append($theme-colors, hsl(154, 33%, 46%))
@debug append($theme-colors, hsl(154, 33%, 54%))
@debug append($theme-colors, hsl(154, 33%, 62%))
@debug append($theme-colors, hsl(154, 33%, 70%))
@debug append($theme-colors, hsl(154, 33%, 78%))
@debug append($theme-colors, hsl(154, 33%, 86%))
@debug append($theme-colors, hsl(154, 33%, 94%))

// add bluish
@debug append($theme-colors, hsl(10, 61%, 1%))
@debug append($theme-colors, hsl(10, 61%, 9%))
@debug append($theme-colors, hsl(10, 61%, 17%))
@debug append($theme-colors, hsl(10, 61%, 25%))
@debug append($theme-colors, hsl(10, 61%, 33%))
@debug append($theme-colors, hsl(10, 61%, 41%))
@debug append($theme-colors, hsl(10, 61%, 49%))
@debug append($theme-colors, hsl(10, 61%, 57%))
@debug append($theme-colors, hsl(10, 61%, 65%))
@debug append($theme-colors, hsl(10, 61%, 73%))
@debug append($theme-colors, hsl(10, 61%, 81%))
@debug append($theme-colors, hsl(10, 61%, 89%))
@debug append($theme-colors, hsl(10, 61%, 97%))

// OK button accent ("primary"??)
@debug append($theme-colors, rgb(52, 103, 81))
@debug append($theme-colors, rgb(201, 74, 49))
// Must be some foreground (border or text)
// ^ too dark for foreground; eventually for the border.
// Leans more towards white (but still room for hover - getting lighter)
// but must try out using an anchor or similar...
// ...or additionally make the text bolder when hovering
@debug append($theme-colors, rgb(236, 236, 236))
```

Categories

* Background
  * Lighter/Darker
  * Default/"Undefault"???
  * Primary/Secondary
    * The primary is the default background.
    * The secondary is used e.g. for panel headers or application bars.
* Foreground : This is the text color.
  * On Primary/On Secondary
    * Must provide good contrast.
* Accent colors
  * Background of selected row
    * Lighter (cf. "Project" overview in IntelliJ)
    * Darker (cf. Editor &rarr; current line)
  * Selected row in "Project" overview
    * ...w/ focus
    * ...w/o focus
