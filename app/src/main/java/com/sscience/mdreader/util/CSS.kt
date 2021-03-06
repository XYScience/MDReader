package com.sscience.mdreader.util

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2018/1/7
 */
class CSS private constructor() {

    companion object {

        val github: String = "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width initial-scale=1 user-scalable=no\">\n" +
                "<title>MD Reader</title>\n" +
                "<style>img{max-width: 100%; width:auto; height:auto;}</style>\n" +
                "<style>\n" +
                // GitHub CSS Start
                ":root {\n" +
                "    --side-bar-bg-color: #fafafa;\n" +
                "    --control-text-color: #777;\n" +
                "}\n" +
                "\n" +
                "@include-when-export url(http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,700,400&subset=latin,latin-ext);\n" +
                "\n" +
                "@font-face {\n" +
                "    font-family: 'Open Sans';\n" +
                "    font-style: normal;\n" +
                "    font-weight: normal;\n" +
                "    src: local('Open Sans Regular'),url('./github/400.woff') format('woff')\n" +
                "}\n" +
                "\n" +
                "@font-face {\n" +
                "    font-family: 'Open Sans';\n" +
                "    font-style: italic;\n" +
                "    font-weight: normal;\n" +
                "    src: local('Open Sans Italic'),url('./github/400i.woff') format('woff')\n" +
                "}\n" +
                "\n" +
                "@font-face {\n" +
                "    font-family: 'Open Sans';\n" +
                "    font-style: normal;\n" +
                "    font-weight: bold;\n" +
                "    src: local('Open Sans Bold'),url('./github/700.woff') format('woff')\n" +
                "}\n" +
                "\n" +
                "@font-face {\n" +
                "    font-family: 'Open Sans';\n" +
                "    font-style: italic;\n" +
                "    font-weight: bold;\n" +
                "    src: local('Open Sans Bold Italic'),url('./github/700i.woff') format('woff')\n" +
                "}\n" +
                "\n" +
                "html {\n" +
                "    font-size: 16px;\n" +
                "}\n" +
                "\n" +
                "body {\n" +
                "    font-family: \"Open Sans\",\"Clear Sans\",\"Helvetica Neue\",Helvetica,Arial,sans-serif;\n" +
                "    color: rgb(51, 51, 51);\n" +
                "    line-height: 1.6;\n" +
                "}\n" +
                "\n" +
                "#write{\n" +
                "    max-width: 860px;\n" +
                "  \tmargin: 0 auto;\n" +
                "  \tpadding: 20px 30px 40px 30px;\n" +
                "\tpadding-top: 20px;\n" +
                "    padding-bottom: 100px;\n" +
                "}\n" +
                "#write > ul:first-child,\n" +
                "#write > ol:first-child{\n" +
                "    margin-top: 30px;\n" +
                "}\n" +
                "\n" +
                "body > *:first-child {\n" +
                "    margin-top: 0 !important;\n" +
                "}\n" +
                "body > *:last-child {\n" +
                "    margin-bottom: 0 !important;\n" +
                "}\n" +
                "a {\n" +
                "    color: #4183C4;\n" +
                "}\n" +
                "h1,\n" +
                "h2,\n" +
                "h3,\n" +
                "h4,\n" +
                "h5,\n" +
                "h6 {\n" +
                "    position: relative;\n" +
                "    margin-top: 1rem;\n" +
                "    margin-bottom: 1rem;\n" +
                "    font-weight: bold;\n" +
                "    line-height: 1.4;\n" +
                "    cursor: text;\n" +
                "}\n" +
                "h1:hover a.anchor,\n" +
                "h2:hover a.anchor,\n" +
                "h3:hover a.anchor,\n" +
                "h4:hover a.anchor,\n" +
                "h5:hover a.anchor,\n" +
                "h6:hover a.anchor {\n" +
                "    /*background: url(\"../../images/modules/styleguide/para.png\") no-repeat 10px center;*/\n" +
                "    text-decoration: none;\n" +
                "}\n" +
                "h1 tt,\n" +
                "h1 code {\n" +
                "    font-size: inherit;\n" +
                "}\n" +
                "h2 tt,\n" +
                "h2 code {\n" +
                "    font-size: inherit;\n" +
                "}\n" +
                "h3 tt,\n" +
                "h3 code {\n" +
                "    font-size: inherit;\n" +
                "}\n" +
                "h4 tt,\n" +
                "h4 code {\n" +
                "    font-size: inherit;\n" +
                "}\n" +
                "h5 tt,\n" +
                "h5 code {\n" +
                "    font-size: inherit;\n" +
                "}\n" +
                "h6 tt,\n" +
                "h6 code {\n" +
                "    font-size: inherit;\n" +
                "}\n" +
                "h1 {\n" +
                "    padding-bottom: .3em;\n" +
                "    font-size: 2.25em;\n" +
                "    line-height: 1.2;\n" +
                "    border-bottom: 1px solid #eee;\n" +
                "}\n" +
                "h2 {\n" +
                "   padding-bottom: .3em;\n" +
                "    font-size: 1.75em;\n" +
                "    line-height: 1.225;\n" +
                "    border-bottom: 1px solid #eee;\n" +
                "}\n" +
                "h3 {\n" +
                "    font-size: 1.5em;\n" +
                "    line-height: 1.43;\n" +
                "}\n" +
                "h4 {\n" +
                "    font-size: 1.25em;\n" +
                "}\n" +
                "h5 {\n" +
                "    font-size: 1em;\n" +
                "}\n" +
                "h6 {\n" +
                "   font-size: 1em;\n" +
                "    color: #777;\n" +
                "}\n" +
                "p,\n" +
                "blockquote,\n" +
                "ul,\n" +
                "ol,\n" +
                "dl,\n" +
                "table{\n" +
                "    margin: 0.8em 0;\n" +
                "}\n" +
                "li>ol,\n" +
                "li>ul {\n" +
                "    margin: 0 0;\n" +
                "}\n" +
                "hr {\n" +
                "    height: 4px;\n" +
                "    padding: 0;\n" +
                "    margin: 16px 0;\n" +
                "    background-color: #e7e7e7;\n" +
                "    border: 0 none;\n" +
                "    overflow: hidden;\n" +
                "    box-sizing: content-box;\n" +
                "    border-bottom: 1px solid #ddd;\n" +
                "}\n" +
                "\n" +
                "body > h2:first-child {\n" +
                "    margin-top: 0;\n" +
                "    padding-top: 0;\n" +
                "}\n" +
                "body > h1:first-child {\n" +
                "    margin-top: 0;\n" +
                "    padding-top: 0;\n" +
                "}\n" +
                "body > h1:first-child + h2 {\n" +
                "    margin-top: 0;\n" +
                "    padding-top: 0;\n" +
                "}\n" +
                "body > h3:first-child,\n" +
                "body > h4:first-child,\n" +
                "body > h5:first-child,\n" +
                "body > h6:first-child {\n" +
                "    margin-top: 0;\n" +
                "    padding-top: 0;\n" +
                "}\n" +
                "a:first-child h1,\n" +
                "a:first-child h2,\n" +
                "a:first-child h3,\n" +
                "a:first-child h4,\n" +
                "a:first-child h5,\n" +
                "a:first-child h6 {\n" +
                "    margin-top: 0;\n" +
                "    padding-top: 0;\n" +
                "}\n" +
                "h1 p,\n" +
                "h2 p,\n" +
                "h3 p,\n" +
                "h4 p,\n" +
                "h5 p,\n" +
                "h6 p {\n" +
                "    margin-top: 0;\n" +
                "}\n" +
                "li p.first {\n" +
                "    display: inline-block;\n" +
                "}\n" +
                "ul,\n" +
                "ol {\n" +
                "    padding-left: 30px;\n" +
                "}\n" +
                "ul:first-child,\n" +
                "ol:first-child {\n" +
                "    margin-top: 0;\n" +
                "}\n" +
                "ul:last-child,\n" +
                "ol:last-child {\n" +
                "    margin-bottom: 0;\n" +
                "}\n" +
                "blockquote {\n" +
                "    border-left: 4px solid #dddddd;\n" +
                "    padding: 0 15px;\n" +
                "    color: #777777;\n" +
                "}\n" +
                "blockquote blockquote {\n" +
                "    padding-right: 0;\n" +
                "}\n" +
                "table {\n" +
                "    padding: 0;\n" +
                "    word-break: initial;\n" +
                "}\n" +
                "table tr {\n" +
                "    border-top: 1px solid #cccccc;\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                "}\n" +
                "table tr:nth-child(2n) {\n" +
                "    background-color: #f8f8f8;\n" +
                "}\n" +
                "table tr th {\n" +
                "    font-weight: bold;\n" +
                "    border: 1px solid #cccccc;\n" +
                "    text-align: left;\n" +
                "    margin: 0;\n" +
                "    padding: 6px 13px;\n" +
                "}\n" +
                "table tr td {\n" +
                "    border: 1px solid #cccccc;\n" +
                "    text-align: left;\n" +
                "    margin: 0;\n" +
                "    padding: 6px 13px;\n" +
                "}\n" +
                "table tr th:first-child,\n" +
                "table tr td:first-child {\n" +
                "    margin-top: 0;\n" +
                "}\n" +
                "table tr th:last-child,\n" +
                "table tr td:last-child {\n" +
                "    margin-bottom: 0;\n" +
                "}\n" +
                "\n" +
                ".CodeMirror-gutters {\n" +
                "    border-right: 1px solid #ddd;\n" +
                "}\n" +
                "\n" +
                ".md-fences,\n" +
                "code,\n" +
                "tt {\n" +
                "    border: 1px solid #ddd;\n" +
                "    background-color: #f8f8f8;\n" +
                "    border-radius: 3px;\n" +
                "    padding: 0;\n" +
                "    font-family: Consolas, \"Liberation Mono\", Courier, monospace;\n" +
                "    padding: 2px 4px 0px 4px;\n" +
                "    font-size: 0.9em;\n" +
                "}\n" +
                "\n" +
                ".md-fences {\n" +
                "    margin-bottom: 15px;\n" +
                "    margin-top: 15px;\n" +
                "    padding: 0.2em 1em;\n" +
                "    padding-top: 8px;\n" +
                "    padding-bottom: 6px;\n" +
                "}\n" +
                ".task-list{\n" +
                "\tpadding-left: 0;\n" +
                "}\n" +
                "\n" +
                ".task-list-item {\n" +
                "\tpadding-left:32px;\n" +
                "}\n" +
                "\n" +
                ".task-list-item input {\n" +
                "  top: 3px;\n" +
                "  left: 8px;\n" +
                "}\n" +
                "\n" +
                "@media screen and (min-width: 914px) {\n" +
                "    /*body {\n" +
                "        width: 854px;\n" +
                "        margin: 0 auto;\n" +
                "    }*/\n" +
                "}\n" +
                "@media print {\n" +
                "    html {\n" +
                "        font-size: 13px;\n" +
                "    }\n" +
                "    table,\n" +
                "    pre {\n" +
                "        page-break-inside: avoid;\n" +
                "    }\n" +
                "    pre {\n" +
                "        word-wrap: break-word;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                ".md-fences {\n" +
                "\tbackground-color: #f8f8f8;\n" +
                "}\n" +
                "#write pre.md-meta-block {\n" +
                "\tpadding: 1rem;\n" +
                "    font-size: 85%;\n" +
                "    line-height: 1.45;\n" +
                "    background-color: #f7f7f7;\n" +
                "    border: 0;\n" +
                "    border-radius: 3px;\n" +
                "    color: #777777;\n" +
                "    margin-top: 0 !important;\n" +
                "}\n" +
                "\n" +
                ".mathjax-block>.code-tooltip {\n" +
                "\tbottom: .375rem;\n" +
                "}\n" +
                "\n" +
                "#write>h3.md-focus:before{\n" +
                "\tleft: -1.5625rem;\n" +
                "\ttop: .375rem;\n" +
                "}\n" +
                "#write>h4.md-focus:before{\n" +
                "\tleft: -1.5625rem;\n" +
                "\ttop: .285714286rem;\n" +
                "}\n" +
                "#write>h5.md-focus:before{\n" +
                "\tleft: -1.5625rem;\n" +
                "\ttop: .285714286rem;\n" +
                "}\n" +
                "#write>h6.md-focus:before{\n" +
                "\tleft: -1.5625rem;\n" +
                "\ttop: .285714286rem;\n" +
                "}\n" +
                ".md-image>.md-meta {\n" +
                "    border: 1px solid #ddd;\n" +
                "    border-radius: 3px;\n" +
                "    font-family: Consolas, \"Liberation Mono\", Courier, monospace;\n" +
                "    padding: 2px 4px 0px 4px;\n" +
                "    font-size: 0.9em;\n" +
                "    color: inherit;\n" +
                "}\n" +
                "\n" +
                ".md-tag{\n" +
                "\tcolor: inherit;\n" +
                "}\n" +
                "\n" +
                ".md-toc { \n" +
                "    margin-top:20px;\n" +
                "    padding-bottom:20px;\n" +
                "}\n" +
                "\n" +
                ".sidebar-tabs {\n" +
                "    border-bottom: none;\n" +
                "}\n" +
                "\n" +
                "#typora-quick-open {\n" +
                "    border: 1px solid #ddd;\n" +
                "    background-color: #f8f8f8;\n" +
                "}\n" +
                "\n" +
                "#typora-quick-open-item {\n" +
                "    background-color: #FAFAFA;\n" +
                "    border-color: #FEFEFE #e5e5e5 #e5e5e5 #eee;\n" +
                "    border-style: solid;\n" +
                "    border-width: 1px;\n" +
                "}\n" +
                "\n" +
                "#md-notification:before {\n" +
                "    top: 10px;\n" +
                "}\n" +
                "\n" +
                "/** focus mode */\n" +
                ".on-focus-mode blockquote {\n" +
                "    border-left-color: rgba(85, 85, 85, 0.12);\n" +
                "}\n" +
                "\n" +
                "header, .context-menu, .megamenu-content, footer{\n" +
                "    font-family: \"Segoe UI\", \"Arial\", sans-serif;\n" +
                "}\n" +
                "\n" +
                ".file-node-content:hover .file-node-icon,\n" +
                ".file-node-content:hover .file-node-open-state{\n" +
                "    visibility: visible;\n" +
                "}\n" +
                "\n" +
                ".mac-seamless-mode #typora-sidebar {\n" +
                "    background-color: #fafafa;\n" +
                "    background-color: var(--side-bar-bg-color);\n" +
                "}\n" +
                "\n" +
                ".md-lang {\n" +
                "    color: #b4654d;\n" +
                "}\n" +
                // GitHub CSS End
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"content\">"

        val end: String = "</div>" +
                "</body>\n" +
                "</html>"

        val github2 = "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "  <meta charset=\"utf-8\"/>\n" +
                "<style>img{max-width: 100%; width:auto; height:auto;}</style>\n" +
                "<style>" +
                "\n" +
                "/* RESET\n" +
                "=============================================================================*/\n" +
                "\n" +
                "html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {\n" +
                "  margin: 0;\n" +
                "  padding: 0;\n" +
                "  border: 0;\n" +
                "}\n" +
                "\n" +
                "/* BODY\n" +
                "=============================================================================*/\n" +
                "\n" +
                "body {\n" +
                "  font-family: Helvetica, arial, freesans, clean, sans-serif;\n" +
                "  font-size: 14px;\n" +
                "  line-height: 1.6;\n" +
                "  color: #333;\n" +
                "  background-color: #fff;\n" +
                "  padding: 20px;\n" +
                "  max-width: 960px;\n" +
                "  margin: 0 auto;\n" +
                "}\n" +
                "\n" +
                "body>*:first-child {\n" +
                "  margin-top: 0 !important;\n" +
                "}\n" +
                "\n" +
                "body>*:last-child {\n" +
                "  margin-bottom: 0 !important;\n" +
                "}\n" +
                "\n" +
                "/* BLOCKS\n" +
                "=============================================================================*/\n" +
                "\n" +
                "p, blockquote, ul, ol, dl, table, pre {\n" +
                "  margin: 15px 0;\n" +
                "}\n" +
                "\n" +
                "/* HEADERS\n" +
                "=============================================================================*/\n" +
                "\n" +
                "h1, h2, h3, h4, h5, h6 {\n" +
                "  margin: 20px 0 10px;\n" +
                "  padding: 0;\n" +
                "  font-weight: bold;\n" +
                "  -webkit-font-smoothing: antialiased;\n" +
                "}\n" +
                "\n" +
                "h1 tt, h1 code, h2 tt, h2 code, h3 tt, h3 code, h4 tt, h4 code, h5 tt, h5 code, h6 tt, h6 code {\n" +
                "  font-size: inherit;\n" +
                "}\n" +
                "\n" +
                "h1 {\n" +
                "  font-size: 28px;\n" +
                "  color: #000;\n" +
                "}\n" +
                "\n" +
                "h2 {\n" +
                "  font-size: 24px;\n" +
                "  border-bottom: 1px solid #ccc;\n" +
                "  color: #000;\n" +
                "}\n" +
                "\n" +
                "h3 {\n" +
                "  font-size: 18px;\n" +
                "}\n" +
                "\n" +
                "h4 {\n" +
                "  font-size: 16px;\n" +
                "}\n" +
                "\n" +
                "h5 {\n" +
                "  font-size: 14px;\n" +
                "}\n" +
                "\n" +
                "h6 {\n" +
                "  color: #777;\n" +
                "  font-size: 14px;\n" +
                "}\n" +
                "\n" +
                "body>h2:first-child, body>h1:first-child, body>h1:first-child+h2, body>h3:first-child, body>h4:first-child, body>h5:first-child, body>h6:first-child {\n" +
                "  margin-top: 0;\n" +
                "  padding-top: 0;\n" +
                "}\n" +
                "\n" +
                "a:first-child h1, a:first-child h2, a:first-child h3, a:first-child h4, a:first-child h5, a:first-child h6 {\n" +
                "  margin-top: 0;\n" +
                "  padding-top: 0;\n" +
                "}\n" +
                "\n" +
                "h1+p, h2+p, h3+p, h4+p, h5+p, h6+p {\n" +
                "  margin-top: 10px;\n" +
                "}\n" +
                "\n" +
                "/* LINKS\n" +
                "=============================================================================*/\n" +
                "\n" +
                "a {\n" +
                "  color: #4183C4;\n" +
                "  text-decoration: none;\n" +
                "}\n" +
                "\n" +
                "a:hover {\n" +
                "  text-decoration: underline;\n" +
                "}\n" +
                "\n" +
                "/* LISTS\n" +
                "=============================================================================*/\n" +
                "\n" +
                "ul, ol {\n" +
                "  padding-left: 30px;\n" +
                "}\n" +
                "\n" +
                "ul li > :first-child, \n" +
                "ol li > :first-child, \n" +
                "ul li ul:first-of-type, \n" +
                "ol li ol:first-of-type, \n" +
                "ul li ol:first-of-type, \n" +
                "ol li ul:first-of-type {\n" +
                "  margin-top: 0px;\n" +
                "}\n" +
                "\n" +
                "ul ul, ul ol, ol ol, ol ul {\n" +
                "  margin-bottom: 0;\n" +
                "}\n" +
                "\n" +
                "dl {\n" +
                "  padding: 0;\n" +
                "}\n" +
                "\n" +
                "dl dt {\n" +
                "  font-size: 14px;\n" +
                "  font-weight: bold;\n" +
                "  font-style: italic;\n" +
                "  padding: 0;\n" +
                "  margin: 15px 0 5px;\n" +
                "}\n" +
                "\n" +
                "dl dt:first-child {\n" +
                "  padding: 0;\n" +
                "}\n" +
                "\n" +
                "dl dt>:first-child {\n" +
                "  margin-top: 0px;\n" +
                "}\n" +
                "\n" +
                "dl dt>:last-child {\n" +
                "  margin-bottom: 0px;\n" +
                "}\n" +
                "\n" +
                "dl dd {\n" +
                "  margin: 0 0 15px;\n" +
                "  padding: 0 15px;\n" +
                "}\n" +
                "\n" +
                "dl dd>:first-child {\n" +
                "  margin-top: 0px;\n" +
                "}\n" +
                "\n" +
                "dl dd>:last-child {\n" +
                "  margin-bottom: 0px;\n" +
                "}\n" +
                "\n" +
                "/* CODE\n" +
                "=============================================================================*/\n" +
                "\n" +
                "pre, code, tt {\n" +
                "  font-size: 12px;\n" +
                "  font-family: Consolas, \"Liberation Mono\", Courier, monospace;\n" +
                "}\n" +
                "\n" +
                "code, tt {\n" +
                "  margin: 0 0px;\n" +
                "  padding: 0px 0px;\n" +
                "  white-space: nowrap;\n" +
                "  border: 1px solid #eaeaea;\n" +
                "  background-color: #f8f8f8;\n" +
                "  border-radius: 3px;\n" +
                "overflow-x: scroll;\n" +
                "  overflow-y: hidden;\n" +
                "}\n" +
                "\n" +
                "pre>code {\n" +
                "  margin: 0;\n" +
                "  padding: 0;\n" +
                "  white-space: pre;\n" +
                "  border: none;\n" +
                "  background: transparent;\n" +
                "}\n" +
                "\n" +
                "pre {\n" +
                "  background-color: #f8f8f8;\n" +
                "  border: 1px solid #ccc;\n" +
                "  font-size: 13px;\n" +
                "  line-height: 19px;\n" +
                "  overflow: auto;\n" +
                "  padding: 6px 10px;\n" +
                "  border-radius: 3px;\n" +
                "}\n" +
                "\n" +
                "pre code, pre tt {\n" +
                "  background-color: transparent;\n" +
                "  border: none;\n" +
                "}\n" +
                "\n" +
                "kbd {\n" +
                "    -moz-border-bottom-colors: none;\n" +
                "    -moz-border-left-colors: none;\n" +
                "    -moz-border-right-colors: none;\n" +
                "    -moz-border-top-colors: none;\n" +
                "    background-color: #DDDDDD;\n" +
                "    background-image: linear-gradient(#F1F1F1, #DDDDDD);\n" +
                "    background-repeat: repeat-x;\n" +
                "    border-color: #DDDDDD #CCCCCC #CCCCCC #DDDDDD;\n" +
                "    border-image: none;\n" +
                "    border-radius: 2px 2px 2px 2px;\n" +
                "    border-style: solid;\n" +
                "    border-width: 1px;\n" +
                "    font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;\n" +
                "    line-height: 10px;\n" +
                "    padding: 1px 4px;\n" +
                "}\n" +
                "\n" +
                "/* QUOTES\n" +
                "=============================================================================*/\n" +
                "\n" +
                "blockquote {\n" +
                "  border-left: 4px solid #DDD;\n" +
                "  padding: 0 15px;\n" +
                "  color: #777;\n" +
                "}\n" +
                "\n" +
                "blockquote>:first-child {\n" +
                "  margin-top: 0px;\n" +
                "}\n" +
                "\n" +
                "blockquote>:last-child {\n" +
                "  margin-bottom: 0px;\n" +
                "}\n" +
                "\n" +
                "/* HORIZONTAL RULES\n" +
                "=============================================================================*/\n" +
                "\n" +
                "hr {\n" +
                "  clear: both;\n" +
                "  margin: 15px 0;\n" +
                "  height: 0px;\n" +
                "  overflow: hidden;\n" +
                "  border: none;\n" +
                "  background: transparent;\n" +
                "  border-bottom: 4px solid #ddd;\n" +
                "  padding: 0;\n" +
                "}\n" +
                "\n" +
                "/* TABLES\n" +
                "=============================================================================*/\n" +
                "\n" +
                "table th {\n" +
                "  font-weight: bold;\n" +
                "}\n" +
                "\n" +
                "table th, table td {\n" +
                "  border: 1px solid #ccc;\n" +
                "  padding: 6px 13px;\n" +
                "}\n" +
                "\n" +
                "table tr {\n" +
                "  border-top: 1px solid #ccc;\n" +
                "  background-color: #fff;\n" +
                "}\n" +
                "\n" +
                "table tr:nth-child(2n) {\n" +
                "  background-color: #f8f8f8;\n" +
                "}\n" +
                "\n" +
                "/* IMAGES\n" +
                "=============================================================================*/\n" +
                "\n" +
                "img {\n" +
                "  max-width: 100%\n" +
                "}" +
                "</style>\n" +
                "  <title>MDReader</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div id=\"content\">"
    }
}