#! /bin/bash

touch $1

for ((i=0 ; i<15 ; i++))
	do
		t=$((32*i+16))
		echo "$t 16 32" >> $1
		echo "$t 464 32" >> $1
	done

for ((i=1 ; i<14 ; i++))
	do
		t=$((32*i+16))
		echo "16 $t 32" >> $1
		echo "464 $t 32" >> $1
	done

for ((i=2 ; i<13 ; i+=2)) do
	for ((j=2 ; j<13 ; j+=2))
		do 
			t=$((32*i+16))
			t2=$((32*j+16))
			echo "$t $t2 32" >> $1
	done
done

