# Software Studio Assignment 6

## Notes
+ You will have to import the libraries on your own. All the libraries are provided on iLMS.
+ Even you followed the design TA shown in the video, you still have to explain the control of the program in the next section.

## Explanation of the Design
Explain your design in this section.  
Example:
### Operation
+ Clicking on the button "Add All": users can add all the characters into network to be analyzed.
+ 按下Add All的按鍵，就可以把所有的腳色加入圓圈中，並且建立連線來表達圓圈內腳色互相的關係。
+ Clicking on the button "Clear": users can remove all the characters from network.
+ 按下Clear的按鍵，所有在圓圈內的腳色將會回到原位，也就是尚未顯示互相關係的狀態，並且整齊地排列在左方。
+ Hovering on the character: the name of the character will be revealed.
+ 將滑鼠移動到腳色圓圈上面，就會顯示腳色的名字。
+ By dragging the little circle and drop it in the big circle, the character will be added to the network.
+ 按住滑鼠，拖曳到圓圈內部，就會將腳色加入關係網中，所有與腳色有關係的腳色都會有直線連線來代表其關係。
+ By pressing key 1~7 on the keyboard, users can switch between episodes.
+ 按數字鍵1234567，就可以切換不同集的腳色池。

### Visualization
+ The width of each link is visualized based on the value of the link.
+ 腳色與腳色之間所建立連線的直線，會因為腳色之間的關係緊密或是稀疏，擁有不同的粗細，關係越緊密，或是腳色越重要，直線將會越粗。
+ 畫面中上方顯示目前是Star Wars的第幾集，不同集數，腳色也會有所不同。。
+ 拖曳到圓圈內的腳色，將建立關係網，讓使用者可以清楚地了解到腳色與腳色之間的關係。
+ 越重要的腳色，就會有不同的顏色，其餘小角色的顏色就會是灰色且相同，用以區分主要腳色和跑龍套腳色。
+ 如果腳色沒有準確的拖曳到圓圈中，那麼他將會回到原來在左方的位置。
