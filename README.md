SpaceGDN Java Client
-----

> Java client library for working with [SpaceGDN](https://github.com/connor4312/SpaceGDN). Uses Maven.

#### Installation
Instructions will come soon.

#### Example Usage
```java
// Imports
import net.boboman13.spacegdnbridge.*;

public class MyClass {
	public void myFunction() {
		Bridge bridge = new Bridge(); // Uses xereo's host by default
		
		// Simple example
		APIRequest request = bridge.newRequest();
		APIResponse response = request.get("versions").go();

		// response now contains all the versions.

		// Advanced example
		request = bridge.newRequest();
		response = request
			.jar(6)
			.channel(11)
			.version(105)
			.build(482)
			.go();

		// Now, since we're retrieving a build - we can access that build.
		GDNBuild build = response.build;
		int buildId = build.id;
		String buildURL = build.url;
		// All the values you need are accessible from there.
	}
}

### Documentation
Full documentation to follow.

#### License
[Found here](./LICENSE)
