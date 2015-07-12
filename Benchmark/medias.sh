#!/bin/bash

array=("fib" "fact" "sort" "merge_sort" "m_sum" "m_prod" "m_times")

for element in ${array[@]}
do
    awk < "results_"$element '{ sum += $3; n++ } END { if (n > 0) print  $1 " : " sum / n " ms"; }' >> results.txt
done
