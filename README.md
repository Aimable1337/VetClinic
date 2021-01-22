# VetClinic

Available endpoints: 
    -"/appointments/doctor/{id}/{date}"
        Http method: GET
        Path variables:
            - {id} - type: int; doctor's ID whose schedule you want to check; must contain 4 digits;
            - {date} - type: LocalDate; Format: YYYY:MM:DD; date you want to check; can not be in the past;
    -"/appointments"
        Http method: POST
        Request body: 
        {
            "customerId": XXXX,                     - type: int; customer's id who wants to book appointment; must contain 4 digits;
            "pin" : XXXX,                           - type: int; customer's pin; must contain 4 digits;
            "doctorId": XXXX,                       - type: int; doctor's id customer wants to book appointment for; must contain 4 digits;
            "dateAndTime": "YYYY-MM-DD HH:MM:SS"    - type: LocalDateTime; date and time when customer wants to book appointment
        }                                             it can not be sunday and time has to be between 9 a.m. and 5 p.m.
    -"/appointments"
        Http method: DELETE
        Request body:
        {
        "appointmentId" : XXXX,                     - type: int; appointment's id witch customer wants to cancel; 
        "customerId" : XXXX,                        - type: int; customer's id who wants to cancel appointment; must contain 4 digits
        "pin" : XXXX                                - type: int; customer's pin; must contain 4 digits;
        }