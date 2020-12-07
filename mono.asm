;The lines with
;ld a, $XX
;ldh [rTMA], a
;is where you specify the playback rate.
;the 8-bit value is what the base clock
;is divided by (where the base clock is
;131,072Hz.) How much it is divided by
;can be calculated by subtracting the
;specified amount from 256 and adding 1
;(though you may need to experiment.)
;Play around a bit until you find a rate 
;you like!
;Lowering the rate also makes more audio
;fit onto a single cartridge.
;Using a slightly slower rate than the
;encoded audio makes good lo-fi slowed
;down audio.

;Keep in mind that with interrupts, the
;playback rate of mono audio can't go
;above 32,768Hz while maintaining
;a constant playback rate. Anything
;higher may cause the audio to fluctuate
;a bit.

INCLUDE "hardware.inc"

SECTION "Timer interrupt", ROM0[$50]
TimerInterrupt:
    call playSample
	nop
	nop
	nop
	nop
	nop

SECTION "Header", ROM0[$100]

EntryPoint:
	di
	jp Start

REPT $150 - $104
	db 0
ENDR


SECTION "Game code", ROM0[$150]

Start:
	di
	ld a, $01
	ldh [rKEY1], a
	stop
	nop
	nop
	xor a
	ldh [rNR52], a
	nop
	nop
	nop
	nop
	nop
	nop
	nop
	nop
	ld a, $80
	ldh [rNR52], a
	nop
	nop
	nop
	xor a
	ldh [rIE], a
	ldh [$F8], a
	ldh [$F7], a
	ld sp, $FFFF
	ld hl, $4000
	ld bc, $0100
	xor a
	ldh [rNR10], a
	ld a, $11
	ldh [rNR51], a
	xor a
	ldh [rNR13], a
	ld a, $F0
	ldh [rNR12], a
	ld a, $C0
	ldh [rNR11], a
	ld a, $80
	ldh [rNR14], a
	ld a, $44
	ldh [rNR50], a
	ld a, $F9		;Modify this value to change the playback rate!
	ldh [rTMA], a
	ld a, %00000110
	ldh [rTAC], a
	ld a, $04
	ldh [rIE], a
	ei

waitforInt:
	nop
	nop
	jr waitforInt

playSample:
	ld a, [hl]
	ld e, a   
	and $F0  
	ld d, a    
	jr nz, regPulse1 
	ld a, $1F
	ldh [rNR12], a
	ld a, $40
	ldh [$F8], a
	jr PCM1

regPulse1:
	ld a, $C0
	ldh [$F8], a
	ld a, d
	or $0F
	ldh [rNR12], a

PCM1:
	ld a, e
	and $07
	ld d, a
	swap a
	or d
	ldh [$F7], a
	ld a, e
	and $08
	jr z, noVol
	ldh a, [$F7]
	ldh [rNR50], a

	ldh a, [$F8]
	ldh [rNR11], a
	
	ld a, $80
	ldh [rNR14], a

	jr endPCM

noVol:	
	ldh a, [$F8]
	ldh [rNR11], a
	
	ld a, $80
	ldh [rNR14], a

	ldh a, [$F7]
	ldh [rNR50], a
endPCM:
	inc l

	jr nz, sampleEnd
	inc h
	ld a, h
	cp $80
	jr nz, sampleEnd
	ld h, $40
	inc b
	ld a, b
	ld [$2000], a
	jr nz, sampleEnd
	ld c, $00
	inc c
	ld a, c
	ld [$3000], a

sampleEnd:
	ld sp, $FFFF
	ei
	;jp playSample ;Only uncomment this if you know what you're doing!
				   ;No interrupt playback is experimental as I don't
				   ;exactly know the precise playback rate.
				   ;Also, comment the previous 2 lines if you use no
				   ;interrupts.

lockup:
	nop
	nop
	nop
	nop
	jr lockup
SECTION "Additional lockup", ROM0[$04FC] ;I included this just to be safe.
	jp lockup