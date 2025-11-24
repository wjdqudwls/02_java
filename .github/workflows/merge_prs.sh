#!/bin/bash

echo Pull requests merge starts...

readarray pr_nums < <(cut -f 1 <<< $(gh pr list | grep [0-9]))
echo ${pr_nums[@]}
echo 'Open pull requests : ' ${#pr_nums[@]} 

for num in "${pr_nums[@]}"
do
	gh pr merge $num -m --admin
	sleep 1
done

echo All of pull requests merged successfully.

