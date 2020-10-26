import 'package:flutter/material.dart';
import 'package:flutter_project/presentation/ui/main_screen.dart';

class SplashScreen extends StatefulWidget {
  @override
  _SplashScreenState createState() => _SplashScreenState();
}

class _SplashScreenState extends State<SplashScreen> {
  @override
  void initState() {
    Future.delayed(Duration(seconds: 3)).then((_) => Navigator.of(context)
        .pushReplacement(
            MaterialPageRoute(builder: (context) => MainScreen())));
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Material(
      child: Center(
        child: Container(
          width: 300,
          height: 300,
          child: FlutterLogo(),
        ),
      ),
    );
  }
}
