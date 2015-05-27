# TwitterEditTextLengthFilter

I spent more time than I wanted to trying to figure out the best way to limit an EditText field to 140 characters. The curveball is that Twitter considers a link, such as t.co, as 22 characters. This code uses Twitter's validator library + an EditText filter I build to prevent the user from typing over the max character limit.
