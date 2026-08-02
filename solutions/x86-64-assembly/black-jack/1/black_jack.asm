; Everything that comes after a semicolon (;) is a comment

C2 equ 2
C3 equ 3
C4 equ 4
C5 equ 5
C6 equ 6
C7 equ 7
C8 equ 8
C9 equ 9
C10 equ 10
CJ equ 11
CQ equ 12
CK equ 13
CA equ 14

TRUE equ 1
FALSE equ 0

section .text

; You should implement functions in the .text section
return_TRUE:
    mov rax, TRUE
    ret

return_FALSE:
    mov rax, FALSE
    ret

return_1:
    mov rax, 1
    ret

return_10:
    cmp rdi, 14
    je return_1

    mov rax, 10
    ret

; the global directive makes a function visible to the test files
global value_of_card
value_of_card:
    ; This function takes as parameter a number representing a card
    ; The function should return the numerical value of the passed-in card
    cmp rdi, 10    
    jae return_10

    mov rax, rdi
    ret

return_a:
    mov rax, r10
    mov rdx, 0
    ret

return_b:
    mov rax, r11
    mov rdx, 0
    ret

global higher_card
higher_card:
    ; This function takes as parameters two numbers each representing a card
    ; The function should return which card has the higher value
    ; If both have the same value, both should be returned
    ; If one is higher, the second one should be 0
    mov r10, rdi
    mov r11, rsi

    call value_of_card
    mov r8, rax

    mov rdi, rsi

    call value_of_card
    mov r9, rax

    cmp r8, r9
    ja return_a

    cmp r8, r9
    jb return_b

    mov rax, r10
    mov rdx, r11

    ret

global value_of_ace
value_of_ace:
    ; This function takes as parameters two numbers each representing a card
    ; The function should return the value of an upcoming ace
    mov r8, rdi
    mov r9, rsi
    cmp r8, 14
    je return_1

    cmp r9, 14
    je return_1

    mov rdi, r8
    call value_of_card
    mov r10, rax

    mov rdi, r9
    call value_of_card
    mov r11, rax

    add r10, r11
    cmp r10, 11
    jae return_1

    mov rax, 11
    ret

global is_blackjack
is_blackjack:
    ; This function takes as parameters two numbers each representing a card
    ; The function should return TRUE if the two cards form a blackjack, and FALSE otherwise
    mov r8, rdi
    mov r9, rsi

    cmp r8, r9
    jae verify_CA

    mov rax, r9
    mov r9, r8
    mov r8, rax
    jb verify_CA

    ret

verify_CA:
    cmp r8, 14
    je verify_value
    mov rax, FALSE
    ret

verify_value:
    mov rdi, r9
    call value_of_card

    cmp rax, 10
    je return_TRUE
    jne return_FALSE

global can_split_pairs
can_split_pairs:
    ; This function takes as parameters two numbers each representing a card
    ; The function should return TRUE if the two cards can be split into two pairs, and FALSE otherwise
    call value_of_card
    mov r8, rax

    mov rdi, rsi
    call value_of_card
    mov r9, rax

    cmp r8, r9
    jne return_FALSE
    je return_TRUE

global can_double_down
can_double_down:
    ; This function takes as parameters two numbers each representing a card
    ; The function should return TRUE if the two cards form a hand that can be doubled down, and FALSE otherwise
    call value_of_card
    mov r8, rax 

    mov rdi, rsi
    call value_of_card
    mov r9, rax

    add r8, r9

    cmp r8, 9
    jae verify_lt
    jb return_FALSE

verify_lt:
    cmp r8, 11
    jbe return_TRUE
    ja return_FALSE

%ifidn __OUTPUT_FORMAT__,elf64
section .note.GNU-stack noalloc noexec nowrite progbits
%endif
