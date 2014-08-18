#!/bin/bash
BEGIN{FS=":";RS="\n"
    print "\t\t\t***CAMPAIGN 1998 CONTRIBUTIONS***"
    print "------------------------------------------\
-----------------------------------"
    printf "%-20s%-15s    %s  |  %s  |  %s  | %s\n",\
	   "NAME", "PHONE", "Jan", "Feb", "Mar", "Total Donated"
    print "------------------------------------------\
-----------------------------------"
    total = 0
}

{
    $6 = $3 + $4 +$5;
    printf "%-20s%-15s %8.2f%8.2f%8.2f  %-8.2f\n", $1, $2, $3, $4, $5, $6;
    total += $6;

    temp = ($3 + 0 < $4 + 0) ? $3 : $4;
    mintemp = ($5 + 0 < temp + 0) ? $5 : temp;
    min = (NR == 1) ? mintemp : min < mintemp ? min : mintemp;

    temp = ($3 + 0 > $4 + 0) ? $3 : $4;
    maxtemp = ($5 + 0 > temp + 0) ? $5 : temp;
    max = (NR == 1) ? maxtemp : max > maxtemp ? max : maxtemp
}

END{
    print "------------------------------------------\
-----------------------------------"
    print "\t\t\t\tSUMARY"
    print "------------------------------------------\
-----------------------------------"
    printf "The campaign received a total of $%.2f for this quarter.\n", total
    printf "The average donation for the %d contributors was $%.2f.\n",\
	    NR, total/NR
    printf "The highest contribution was $%.2f.\n", max
    printf "The lowest contribution was $%.2f\n", min
}
