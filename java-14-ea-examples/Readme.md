# Java 14

[JDK 14](https://openjdk.java.net/projects/jdk/14/) will be released to the general public in March 2020.

## Selected new or improved potential features

At the time of writing (July 2019), JDK 14 has not yet been released.
The first early access build became available on June 17th, 2019 ([source](https://twitter.com/OpenJDK/status/1140535643484971008)).
Given the [relase schedule](https://openjdk.java.net/jeps/3), it is currently unclear which JEPs will be released as part of JDK 14.
The following are JEPs for which it is already clear, that they have some potential of being delivered in March 2020:

- [JEP 343: Packaging Tool](https://openjdk.java.net/jeps/343)
- [JEP 352: Non-Volatile Mapped Byte Buffers](https://openjdk.java.net/jeps/352)

## Future developments to look out for

As a programmer, language features and new or improved APIs are relevant to me while language internals and issues more concerned with the operation (e.g. garbage collection) aren't as relevant.
The following is a selection of projects and JEP drafts which I find interesting.
For a full list of all current projects, check out the [Projects page](https://openjdk.java.net/projects/) and especially the list of projects on the lefthand side.
For a full list of all JEPs (open, implemented or rejected) and JEP drafts, check out [JEP 0: JEP Index](https://openjdk.java.net/jeps/0).

### Project Amber

[Project Amber](https://openjdk.java.net/projects/amber/) aims to explore and deliver small, productivity-oriented Java language features.

Relevant JEPs:

- [JEP 302: Lambda Leftovers](https://openjdk.java.net/jeps/302) (currently on hold)
- [JEP 305: Pattern Matching for instanceof (Preview)](https://openjdk.java.net/jeps/305)
- [JEP 301: Enhanced Enums](https://openjdk.java.net/jeps/301) (currently on hold; see also [[enhanced enums] - end of the road?](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2017-May/000041.html))

### Project Loom

[Project Loom](https://openjdk.java.net/projects/loom/) aims to explore and possibly deliver JVM features and APIs concerning lightweight threads (fibers) and continuations.
More information can be found in the [project wiki](https://wiki.openjdk.java.net/display/loom/Main).

### Project Panama

[Project Panama](https://openjdk.java.net/projects/panama/) aims to improve the connection between the JVM and non-Java APIs.

Relevant JEP:

- [JEP 191: Foreign Function Interface](https://openjdk.java.net/jeps/191)

### Project Valhalla

[Project Valhalla](https://openjdk.java.net/projects/valhalla/) aims to explore and possibly deliver advanced JVM and Java language features.
In contrast to [Project Amber](#project-amber), these features may require modifications to the JVM as well as the language.
More information can be found in the [project wiki](https://wiki.openjdk.java.net/display/valhalla/Main).

Relevant JEPs:

- [JEP 169: Value Objects](https://openjdk.java.net/jeps/169) (part of [Project Valhalla](https://openjdk.java.net/projects/valhalla/))
- [JEP 218: Generics over Primitive Types](https://openjdk.java.net/jeps/218) (part of [Project Valhalla](https://openjdk.java.net/projects/valhalla/))

### Unassigned JEP drafts

The following JEP drafts may become interesting in the near future:

- [JEP draft: Better hash codes](https://openjdk.java.net/jeps/8201462)
- [JEP draft: Concise Method Bodies](https://openjdk.java.net/jeps/8209434)
- [JEP draft: Pattern matching for switch (Preview)](https://openjdk.java.net/jeps/8213076)
- [JEP draft: Keyword Management for the Java Language](https://openjdk.java.net/jeps/8223002)
- [JEP draft: Records for the Java Language (Preview)](https://openjdk.java.net/jeps/8222777) (see also [Data Classes and Sealed Types for Java](https://cr.openjdk.java.net/~briangoetz/amber/datum.html))
- [JEP draft: Helpful NullPointerExceptions](https://openjdk.java.net/jeps/8220715)
- [JEP draft: Lazy Static Final Fields](https://openjdk.java.net/jeps/8209964)
