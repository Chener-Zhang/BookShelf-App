
# Assigment2 Explanation;

### Global Variable

```
String username;
```
---

#### 1: getting ID and assigned the id to new var 
#### 2: check if it empty
#### 3: for the password part. check st1.match(st2) if yes - > welcome, if no -> re-enter
```
        public int check_input()
        {

           
            exp:
            //get the id
            TextView check_name = findViewById(R.id.User_Name);

            //get the string
            String user_enter_name = check_name.getText().toString();

            // check if it empty
            if (user_enter_name.matches("")) {

            // if it is empty, then warn the user
            Toast.makeText(this, "you must enter name", Toast.LENGTH_SHORT.show();
                return 0;
            }


        }
```
---

#### get the bottom id, whenver the bottom is click, it will call the check_input function();
---
```
    public void save_press() {
        Button save_bottom = findViewById(R.id.save_button);
        save_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_input() == 1) {
                Toast.makeText(FormActivity.this, "Welcome come " + username,   Toast.LENGTH_SHORT).show();
                    System.out.println();
                }
            }
        });


    }
```
---