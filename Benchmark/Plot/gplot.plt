set title "Tiempos en los algortimos del programa benchmark.py"
set terminal png size 1500,1200 font "/Library/Fonts/Times New Roman Bold.ttf, 13"
set output 'hist_gcc_1.png'
set boxwidth 0.9 absolute
set style fill solid 1.00 border -1
set key outside right top vertical Left reverse enhanced autotitles columnhead nobox
set key invert samplen 4 spacing 1 width 0 height 0 
set style histogram rowstacked title offset character 0, 0, 0
set datafile missing '-' 
set style data histograms
set xtics border in scale 1,0.5 nomirror rotate by -45 offset character 0, 0, 0     norangelimit
set ytics 0,100 nomirror
set ytics 50
set yrange [0:700]
set ylabel "Tiempo"
set xlabel "Algoritmos"
plot 'merge.data' using 2:xticlabels(1) ti col
