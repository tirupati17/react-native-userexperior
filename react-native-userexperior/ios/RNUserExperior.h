
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#import "RCTUIManager.h"
#else
#import <React/RCTBridgeModule.h>
#import <React/RCTUIManager.h>
#endif

@interface RNUserExperior : NSObject <RCTBridgeModule>

@end
  
