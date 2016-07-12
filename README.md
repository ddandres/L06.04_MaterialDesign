# L06.04_MaterialDesign
Lecture 06.04 - Material Design, DISCA - UPV, Development of apps for mobile devices.

Displays a list of custom Items using different elements from Material Design:
- FloatingActionButton just displays a SnackBar with an associated action, which scrolls the list to the first element.
- CoordinatorLayout coordinates the FloatingActionButton and SnackBar, so they do not overlap and the SnackBar can be dismissed by swiping.
- Items are displayed using CardView.
- RecyclerView displays an ArrayList<Item> as a vertical/horizontal Linear/Grid/StaggeredGridLayout.
