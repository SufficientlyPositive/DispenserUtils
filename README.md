# DispenserUtils

A small library mod for helping add new dispenser behaviours to Minecraft, using custom items or otherwise.
The following are behaviours added by this library:
<ul>
<li>Placing blocks (using Minecraft's inbuilt <code>AutomaticItemPlacementContext</code> class)</li>
<li>Placing blocks on top of specific blocks (you can filter by specific blocks or by <code>BlockTags</code>)</li>
<li>Using items on blocks (uses Minecraft's <code>useOnBlock()</code> function and therefore will not work with items that do not use this function)</li>
<li>A "hook" behaviour that allows for any item implementing the provided <code>DispensableItem</code> interface to have custom dispenser behaviour implemented</li>
</ul>

In the source files provided on Github, there are examples of how to use the library within the `Examples` class, as well as an `ExampleItem` implementing the `DispensableItem` interface.
These are not included in the .jar.

## License

This library is available under the CC0 License, a copy of which resides within the repository

**IMPORTANT NOTE: Adding additional behaviours to items that already have programmed behaviours will override them. This is simply how vanilla dispensers work and changing this is outside the scope of this mod.**