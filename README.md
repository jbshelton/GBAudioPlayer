If you're reading this, then thanks for downloading!

======================INTRODUCTION====================

I designed and refined this audio player in the span
of about 1 to 2 months, and put... 20? 30? I don't
know how many hours into it. What I DO know is how
quirky the Gameboy's APU can be, and of course how
to play music on a Gameboy (in high quality!)

At this point, I have released the high-quality
audio player I designed for the Gameboy Color only,
but eventually I will refine and release the code
for the audio player that will work on an original
DMG Gameboy or a Gameboy Pocket.

======================COMPATIBILITY===================

A quick note before getting on to how to use it:
this audio player, though GBC compatible, will NOT
work on a Gameboy Advance. Due to the behavior of the
"analog" circuitry being different, the master volume 
register does not work in the same way. The same goes
for the original Gameboy; the volume register doesn't
work the same, so audio playback is... trash, to put
it lightly. So far, I know the player works on BGB,
though not exactly the smoothest.

=======================HOW TO USE=====================

To use the audio player, you must have RGBDS (gameboy
assembly compiler,) the latest version of Java, 
Audacity, a text editor, and  some kind of hex editor 
installed on your computer. If you use Windows like I 
do, you must also install the Linux Subsystem as well 
as Ubuntu or any other Linux command line for Windows. 
There are plenty of tutorials on how to do it on the 
internet so I won't be babbling through it here.

In order to prepare the audio player ROM, follow
these steps:
1. Open the stereo or mono .asm file in your text
editor. The top of it has some documentation on
adjusting the playback rate of audio, so read that
and change the timer's divider value to the frequency
of your choice. Don't forget to save it!
2. In the command line, change to the directory the
audio player package is in. For Windows, typing in
"cd /mnt/(lowercase drive letter)/(path to the folder
the audio player is in)" should work.
3. Type in "rgbasm -o (player ROM).o (player ROM).asm"
(where player ROM is the stereo or mono .asm file in
the directory)
4. "rgblink -o (any ROM name).gbc (player ROM).o"

You now have the base ROM that you can paste audio
into. But we're not done yet; you still need to
encode the audio! (Since I use Audacity here, the
internet is yet again your best friend.)
1. Open the audio file you want to play in Audacity
2. Set the project rate to the frequency you specified
when you changed the timer divider value
3. Export the audio as raw 8-bit PCM, into the folder
where the encoder is
4. Go to the command line, and type 
"javac encoder.java" (only for the first time!)
5. Now type in "java encoder (input).raw (output).raw"
(where input and output are the names of the audio you
just exported, and what you want to name the new audio)
6. After that finishes, open the encoded audio and the
base ROM you compiled earlier in a hex editor
7. Select all of the encoded audio, copy it, scroll
down to the bottom of the base ROM, and paste it
(you should see an empty line at address hex 4000;
paste it there) (remember to save it!)
8. Type into the command line "rgbfix -v -m 0x19 -C 
-p 0 (any ROM name).gbc"

CONGRATULATIONS! You now have an audio ROM that can be
put onto any flash cartridge that's big enough to hold
it, and played on a real Gameboy Color! (Or accurate
emulator of choice.)

=======================HOW IT WORKS====================

I initially came up with the theoretical concept of the
audio player back in July 2020, some time after I
discovered irrlicht's "Gameboy 5th voice" demo and 
LIJI32's GBVP2 video encoder for the GBC (which played 
back stereo 3-bit audio with the video.) 

The 5th voice worked by quickly retriggering the pulse 
channels in order to freeze their duty cycle step, while 
being set to 75% duty. This keeps the signal high, which 
allowed a 1-bit PCM signal to be played by disconnecting 
and reconnecting the channel to the output. 

The GBVP2 audio player works by creating a DC offset by 
enabling all the channels (though never using them) and 
quickly altering the 3-bit master volume registers to 
play back stereo PCM audio. 

I did some additional searching, and found an article 
on Hackaday about "channelhacking the Gameboy." That 
covered how the pulse channels were used to play back 
4-bit PCM, similar to the 5th voice demo.

Now, for how my audio player works:
The first part of the player uses the pulse channels
to play back 4-bit PCM audio, though I made some
improvements because I knew what quirks they had:
Because writing 0 to any of the channel volume 
registers disables the channel entirely, I achieved 
a zero value by setting the pulse to 25%, the binary 
NOT of 75%, so the output would be low (-1 volt,) and
I could make use of all 16 amplitude levels of the
pulse channel DACs.

Not only did I use the pulse channels to play back 4-
bit PCM, I combined that with the amplitude scaling
abilities of the master volume registers! This allows
the audio player to output a total of 60 amplitude
levels. Though the amplitude steps get bigger as the
amplitude moves away from the center, it still allows
quieter audio to play without the quality dropping.

A TL;DR if that just flew right over your head:
The master volume register multiplies the voltage from
the 4-bit pulse volume output by a certain amount to
get higher quality audio than previously achieved by
any other audio demos for the Gameboy.

=================POTENTIAL PLAYBACK FLAWS==============

Even in its probably most refined form, the audio
player isn't without its flaws. 

The first comes from using the highest playback rate 
possible, without interrupts. Because there are a number 
of conditional code statements that increase or decrease 
the amount of cycles the audio player subroutine takes 
to complete, the playback frequency fluctuates a tiny 
bit. This shouldn't be an issue for most of the time.
I also haven't narrowed down the exact frequency it
plays at, so you may want to experiment a bit with it.

The second comes from how the amplitude values are
loaded. Since both the pulse and master volume
registers are used, one will change before the other,
and can cause a small pop in the audio. This is due
to the limitation of having a fixed look-up table for
encoding the amplitude values. I am currently working
on a better encoder that uses a dynamic look-up table
that uses all 128 possible amplitude configurations,
as well as an algorithm that chooses the nearest config
that won't cause any popping to switch to.

==================DEVELOPMENT QUIRKS===================

The pulse channels have to be initialized in a very
specific order in order to be able to play back
PCM audio; otherwise, it'll either be silent, or sound
like utter garbage. I suspect it has to do with timing.

Setting pulse envelope sweep to decreasing checks
to see if the next envelope step is zero. This causes
the channel to consistently disable when the initial 
value is 1, but also randomly disables the channel 
even if it isn't set to 1. This caused a lot of 
clipping/popping in my earlier audio player versions,
because the channel was disabled, causing the amplitude 
to go towards 0 volts (the range is -1 to 1 volt.)
Fortunately, since I tested and debugged this program 
on a GB Boy Colour, I worked out those issues.

I also noticed a clipping/popping problem testing out
a VERY early, 4-bit only version of my audio player
that only happened when I used my DMG. It happened
more on the left channel (controlled by Pulse 1) at
the time, though it may have had something to do with
the fact that the capacitors were going bad, because
after it played back some more audio, the problem
wasn't as bad.

==========WHERE CAN I LISTEN TO IT IN ACTION?===========

I made an oscilloscope view video of it in action; go
watch it here! https://youtu.be/qkmQra0ZPJo
