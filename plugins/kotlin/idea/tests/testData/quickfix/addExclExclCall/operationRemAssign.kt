// "Add non-null asserted (!!) call" "true"
fun test() {
    var i: Int? = 0
    i %=<caret> 2
}

/* IGNORE_K2 */

// FUS_QUICKFIX_NAME: org.jetbrains.kotlin.idea.quickfix.AddExclExclCallFix