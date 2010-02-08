#!/usr/bin/perl

@files = <*.png>;
my $i = 0;
foreach $file (@files) {
    #print $file . "\n";
    my $newname = "$i.png";
    system "mv $file $newname";
    $i++;
} 
