package com.photokinisi.controllers.forms;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDataContact {
    @NotNull (message = "Το ονοματεπώνυμο πρέπει να μην είναι null")
    @NotEmpty (message = "Το ονοματεπώνυμο πρέπει να μην είναι κενό")
    private String fullname;

    @NotNull (message = "Το e-mail πρέπει να μην είναι null")
    @NotEmpty (message = "To e-mail πρέπει να μην είναι κενό")
    @Email (message = "Το e-mail δεν είναι έγκυρο")
    private String email;

    @Pattern(regexp = "^[26][0-9]{9}$|^$", message = "Μη έγκυρο τηλέφωνο")
    private String tel;

    @Pattern(regexp = ".{5,}", message = "Το μήνυμα πρέπει να έχει τουλάχιστον 5 χαρακτήρες")
    @Pattern(regexp = ".{0,100}", message = "Το μήνυμα πρέπει να έχει το πολύ 100 χαρακτήρες")
    private String message;
}