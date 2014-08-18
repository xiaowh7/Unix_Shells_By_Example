#!/bin/bash
function average(month) {
    count++
    total += $(month + 2)
    if (count == NR) result = total / count
}

BEGIN{
    FS = ":"
    print "Please enter a month (Only 1, 2 or 3):"
    getline month < "/dev/tty"
    total = 0
}

{average(month)}

END{
    printf "The %d month's average is %6.2f\n", month, result
}
