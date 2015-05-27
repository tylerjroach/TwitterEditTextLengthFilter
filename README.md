# TwitterEditTextLengthFilter

I spent more time than I wanted to trying to figure out the best way to limit an EditText field to 140 characters. The curveball is that Twitter considers a link, such as t.co, as 22 characters. This code uses Twitter's validator library + an EditText filter I build to prevent the user from typing over the max character limit.

```
Copyright 2014 Tyler Roach

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
