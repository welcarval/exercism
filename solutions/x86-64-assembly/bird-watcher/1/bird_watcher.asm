; Everything that comes after a semicolon (;) is a comment
%include "debug.mac"
default rel


section .data
    lcounts db 0, 2, 5, 3, 7, 8, 4, 0
    acounts db 0, 0, 0, 0, 0, 0, 0, 0
    already_counts db 0

section .text

; You should implement functions in the .text section
; A skeleton is provided for the first function

; the global directive makes a function visible to the test files
global last_week_counts
last_week_counts:
    ; This function takes no parameter
    ; It returns a copy of last week's counts as a 8-byte number
    ; At the start of the program, last week's counts are 0, 2, 5, 3, 7, 8 and 4
    ; The last byte of the return value is always zero
    mov rax, qword [lcounts] 
    ret

; TODO: define the 'current_week_counts' function
; This function takes no parameter
; It returns two values:
; - A copy of current week's counts as a 8-byte number.
; - The number of days already filled in the current week, as a 8-byte number.
; All days after the most recent one should have its corresponding byte zeroed-out in the output
; At the start of the program, there is no count for the current week
global current_week_counts
current_week_counts:
    mov rax, qword [acounts]
    movzx rdx, byte [already_counts]
    ret

; TODO: define the 'save_count' function
; This function takes as parameter the most recent count, as a 1-byte number
; It must save this value in a new entry for the current week
; If there is already 7 entries in the current week before the function is called, then:
; - The current week becomes the last week.
; - A new entry is added with the passed value in a new current week.
; The function has no return value
global save_count
save_count:
    cmp byte [already_counts], 7
    je .nova_semana
    
    movzx rcx, byte [already_counts]
    lea rdx, [acounts]
    mov byte [rdx + rcx], dil

    inc byte [already_counts]
    ret

    .nova_semana:
        mov rax, qword [acounts] 
        mov qword [lcounts], rax
        
        mov byte [already_counts], 0
        mov qword [acounts], 0
        mov byte [acounts], dil

        inc byte [already_counts]
        ret

; TODO: define the 'today_count' function
; This function has no parameter
; It returns the most recent entry for the current week, as a 1-byte number
global today_count
today_count:
    lea rax, qword [acounts]
    movzx rcx, byte [already_counts]
    lea rdx, qword [rax + rcx - 1]

    movzx rax, byte [rdx]
    ret

; TODO: define the 'update_today_count' function
; This function takes as parameter a 1-byte number
; It adds this number to the most recent entry for the current week
; This function has no return value
global update_today_count
update_today_count:
    call today_count
    add rax, rdi

    lea rcx, qword [acounts]
    movzx rdx, byte [already_counts]

    mov byte [rcx + rdx - 1], al
    ret

; TODO: define the 'update_week_counts' function
; This function takes as parameter a 8-byte number
; Each byte in the input parameter, but the last, represents a day's count in the current week
; The last byte in the input parameter has no meaning and must be zeroed-out
; This function makes the following changes:
; - The current week becomes the last week.
; - The counts in the input parameter are fully inserted in the current week.
global update_week_counts
update_week_counts:
    mov rax, qword [acounts] 
    mov qword [lcounts], rax
    mov qword [acounts], rdi

    ret

%ifidn __OUTPUT_FORMAT__,elf64
section .note.GNU-stack noalloc noexec nowrite progbits
%endif
