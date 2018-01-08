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

    }
}